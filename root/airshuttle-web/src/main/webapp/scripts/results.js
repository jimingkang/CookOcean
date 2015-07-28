$(function() {

    // 搜索结果每页显示数据条数
    var PAGE_SIZE = 10,
        // 分页条每页显示页码数量
        PAGE_NUM_DISPLAY = 5,

        handler = keywordContrller(),

        keyword = unescape($.getUrlParam('q') || '')

    // 关键字高亮
    function keywordHighlight() {

        var keyword = $('#keyword').val()
        if (!keyword) {

            return
        }
        $('body').unhighlight().highlight(keyword)
    }

    // 渲染分页条
    function renderPager(domID, pageSize, pageIndex, totalRecord, callback, displayEntries) {

        var $this = $(domID)

        $this.empty().pagination(totalRecord, pageSize, {
            'current_page': pageIndex,
            'num_display_entries': displayEntries || 10,
            callback: function(page, component) {

                searchs(callback)
            }
        })
    }

    // 搜索查询
    function searchs() {

        var pageIndex = $('#pager .active>a').text() || 1

        handler.search(PAGE_SIZE, pageIndex, keyword, function(data, totalRecord) {

            $('#result-list').empty().append($.tmpl($('#tmp-result').html(), data))
            $('#total-result').text(totalRecord)
            keywordHighlight()
            renderPager('#pager', PAGE_SIZE, pageIndex - 1, totalRecord)
        })
    }

    $('#keyword').bigAutocomplete({
        "url": "testdata/autocomplate.json",
        "callback": function(data) {

            var keyWord = (data ? data.keyWord : $('#keyword').val())
            $('#keyword').val(keyWord)
            searchs()
        }
    })

    handler.getHot(10, 1, function(data) {

        var $badges,
            i = 0

        $('#hot').empty().append($.tmpl($('#tmp-hot').html(), data))
        $badges = $('#hot').find('.badge')

        $badges.each(function(index, el) {

            $(el).text(index + 1)

            if (index < 3) {
                $(el).addClass('hot-top')
            }
        })
    })

    // 搜索事件
    $('#search').click(function() {

        searchs()
    })

    $('#keyword').val(keyword)

    searchs()
})