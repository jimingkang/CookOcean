(function ($) {
    var cache = {},
	isUndef = function (a) { return typeof a === "undefined" },
	isN = function (a) { return typeof a === "number" && window.isFinite(a) },
	isFunc = function (a) { return typeof a === "function" },
	isStr = function (a) { return typeof a === "string" },
	isArray = function (a) { return a && typeof a === "object" && typeof a.length == "number" && typeof a.splice == "function" && !a.propertyIsEnumerable("length") },
	renderMode = {
	    "array": 0				// 数组、集合，循环模板呈现
		, "arrayLike": 1			// 类似 array 的对象（之后会将其构建为真正的 array）
		, "arguments": 2			// arguments 或类似结构的对象，内部使用 slice 使其变成 array
		, "object": -1				// 将对象直接呈现（即使是集合，也不循环）
	},
	tokenModes = {
	    php: {
	        start: '<%',
	        end: '%>'
	    },
	    jsp: {
	        start: '<?',
	        end: '?>'
	    }
	};
    tokenModes.aspx = tokenModes.jsp;

    function templateEngine(elem) {
        var tokens = tokenModes[$.render.tokenMode], code;
        function buildFn() {
            return function (data) {
                var key, keys = [], values = [];

                function isIlegal(name) {
                    if (/^[\d]/.test(name)) {
                        return false;
                    }
                    if (!(/^[\$a-z_][a-z\$0-9_]*/i).test(name)) {
                        return false;
                    }
                    if ((/^(break|case|catch|continue|debugger|default|delete|do|else|finally|for|function|if|in|instanceof|new|return|switch|this|throw|try|typeof|var|void|while|with)$/)
							.test(name)) {
                        return false;
                    }
                    return true;
                }

                for (key in data) {
                    if (isIlegal(key)) {
                        keys.push(key);
                        values.push(data[key]);
                    }
                }

                return new Function(keys, arguments.callee.code).apply(data, values);
            };
        }

        var tmplAttr = "rendertmpl", id, fn, html, rand = (+new Date), vname = '__p' + rand;  // use a random variable name,  http://www.planeart.cn/?p=1594
        fn = isStr(elem) ? (html = elem, buildFn()) : (elem = $(elem), id = elem.attr(tmplAttr)) && cache[id] ? cache[id] : elem.attr(tmplAttr, id = 'tmpl_' + rand) && (html = elem.html(), cache[id] = buildFn());
        fn.code = (!isStr(elem) && cache[id].code) || "var " + vname + "=[],echo=function(){" + vname + ".push.apply(" + vname + ",arguments);};" + vname + ".push('" + 				// modified 'object' to 'this'
				html.replace(/(\\)/g, "\\\\")			// #BUG fixed: can not process slashes
					  .replace(/(\<\s*\/[^>]+\>)[\n\r\t\s]+(?=\<[^>]+\>)/g, "$1")			// 注意，将所有换行、TAB替换，会对HTML格式产生不可控的影响？且要求模板 Javascript 没有注释、分号齐全
					  .replace(/[\r\n\t]/g, "")
					  .split(tokens.start).join("\t")
					  .replace(new RegExp("((^|\\" + tokens.end + ")[^\t]*)'", 'g'), function (a) { return a.replace(/(')/g, "\r") }) // #BUG fixed: can not process multi qoutes
					  .replace(new RegExp("\t=(.*?)\\" + tokens.end, 'g'), "',$1,'")
					  .split("\t").join("');")
					  .split(tokens.end).join(vname + ".push('")
					  .split("\r").join("\\'")
				+ "');return " + vname + ".join('');";
        return fn;
    }

    function Render(elem, data, options) {

        var self = this, fire = $(this);

        options = $.extend({ autoRender: true }, options);
        options.ajax = isStr(data) ? true : false;
        options.tmplEngine = null;

        $.each("onBeforeLoad,onBeforeRender,onLoad,onRender,onError".split(','), function (i, event) {
            self[event] = function (fn) {
                fire.bind(event, fn);
            };
            if (isFunc(options[event])) {
                fire.bind(event, options[event]);
            }
        });

        function trigger(type, args) {
            var e = $.Event(type), ret;
            ret = fire.trigger(e, args);
            return e.isDefaultPrevented() ? false : isUndef(e.result) ? true : e.result;
        }

        function repeat(opts, data, mode) {
            var tmpl = opts.tmplEngine || (opts.tmplEngine = templateEngine(opts.template));
            return mode < 0 ? tmpl(data) : (function () {
                var i, html = [];
                for (i = 0; i < data.length; i++) {
                    html.push(tmpl(data[i]));
                }
                return html.join('');
            })();
        }

        this.element = elem;
        this.data = data;
        this.render = function (data, mode) {

            var ret, dMode;
            if (isN(data) && isUndef(mode)) {
                mode = data;
                data = this.data;
            } else {
                data = data || this.data;
                if (!this.data) {
                    this.data = data;
                }
            }

            dMode = typeof data === "object" ? (isArray(data) ? 0 : -1) : 0;
            function prep(m) {
                return isN(m) ? m : ((!isUndef(renderMode[m]) && renderMode[m]) || dMode);
            }
            isUndef(mode) ? (mode = options.mode) : (isUndef(options.mode) && (options.mode = mode));
            mode = prep(mode);
            options.mode = prep(options.mode);
            (mode === 1 && (data = $.makeArray(data))) || (mode === 2 && (data = [].slice.apply(data)));

            try {
                ret = repeat(options, data, mode);
            } catch (x) {
                trigger("onError", [{ source: x, message: "Render Error", code: -100 }, data, options, mode]);
                return;
            }
            if (trigger("onBeforeRender", [ret, data, options, mode])) {
                this.element.html(ret);
                trigger("onRender", [ret, data, options, mode]);
                // delete options.tmplEngine;
            }
            return ret;
        };

        var ajaxOpts, oldSuccess;
        if (options.ajax) {
            options.url = this.data;
            if (trigger("onBeforeLoad", [this.data, options])) {
                ajaxOpts = $.extend({
                    url: options.url,
                    type: 'GET',
                    cache: false,
                    dataType: "json",
                    error: function (xhr, status, err) {
                        trigger("onError", [{ source: err, message: "Load Error", code: 110 }, options, xhr])
                    }
                }, options.ajaxOptions);
                ajaxOpts.success && (oldSuccess = ajaxOpts.success);
                ajaxOpts.success = function (d) {
                    var _d = trigger("onLoad", [d, options]);
                    self.data = (typeof _d === "boolean") ? d : _d;
                    if (oldSuccess) { oldSuccess.apply(this, arguments); }
                    options.autoRender && self.render();
                };
                $.ajax(ajaxOpts);
            }
        } else {
            options.autoRender && this.render();
        }
        return this;
    }

    $.fn.render = function (data, template, options) {
        var isTmpl = isStr(template) || !isUndef(template.jquery) || !isUndef(template.nodeType); 	// 如果为 字符串[模板字面值] 或者 jQuery 或者为 DOM [取模板来源DOM]，认为是模板
        if (isN(options) || isStr(options)) { options = { mode: options} }
        options = options || {};
        isTmpl ? (options.template = template) : (options = $.extend(template, options));

        this.data("renderHandler", new Render(this, data, options));
        return this;
    };
    $.render = function (json, tmpl, options) {
        return $("<div>").render(json, tmpl, options).html();
    };
    $.render.tokenMode = "aspx"; 		// the default token mode
    $.render.fromTmpl = function (str) {
        function wrappTokens(s) {
            var tokens = tokenModes[$.render.tokenMode];
            return tokens.start + s + tokens.end;
        }

        return str
			.replace(/\$\{([^\}]*)\}/g, "{{html $1}}")
			.replace(/\{\{\/if\}\}/g, wrappTokens("}"))
			.replace(/\{\{if\s+(?:\(?((?:[^\}]|\}(?!\}))*?)\)?)\s*\}\}/g, wrappTokens("if($1){"))
			.replace(/\{\{else\s*\}\}/g, wrappTokens("}else{"))
			.replace(/\{\{else\s+(?:\(?((?:[^\}]|\}(?!\}))*?)\)?)\s*\}\}/g, wrappTokens("}else if($1){"))
			.replace(/\{\{(?:html|=)\s+(?:\(?((?:[^\}]|\}(?!\}))*)\)?)\s*\}\}/g, wrappTokens("=$1"));
    };
})(jQuery);