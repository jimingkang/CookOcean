function ajaxDataController() {

    function errorDic(code) {
        var errors = {
            '601': '该组别名称已存在',
            '801': '获取数据失败'
        }

        return errors[code] || '发生未知错误，请稍候再重试操作'

    }

    function dataHandle(url, params, callback, async, method) {

        if (!method) {
            throw 'method 参数未设置'
        }

        if ((typeof params) === 'function') {

            callback = params
            params = null
        }

        params = params || {}
        async = async || true

        $.ajax({
            async: async,
            url: url,
            dataType: 'json',
            data: params,
            type: method,
            contentType: 'application/json;charset=UTF-8',
            complete: function(xhr) {
                try {
                    var result = JSON.parse(xhr.responseText),
                        DOM_ID = 'promptDialog',
                        code = parseInt(result.status.code),
                        message = result.status.message,
                        prompt = {
                            'id': DOM_ID,
                            'title': '操作结果',
                            'message': errorDic(code)
                        }
                } catch (err) {

                    prompt = {
                        'id': DOM_ID,
                        'title': '操作结果',
                        'message': '数据请求异常，请稍候重试'
                    }

                    message = err.message
                }

                if (code !== 200) {

                    console.log('错误码：' + code + '\n异常信息：' + message)
                    return
                }

                callback(result.data)
            }
        })
    }

    return {
        'insert': function(url, params, callback, async) {

            dataHandle(url, JSON.stringify(params), callback, async, 'post')
        },
        'update': function(url, params, callback, async) {

            dataHandle(url, JSON.stringify(params), callback, async, 'put')
        },
        'delete': function(url, params, callback, async) {

            dataHandle(url, params, callback, async, 'delete')
        },
        'select': function(url, params, callback, async) {

            dataHandle(url, params, callback, async, 'get')
        }
    };
}