function keywordContrller() {

    // AJAX 数据请求处理
    var ajaxHandler = ajaxDataController(),

        // 搜索结果  
        GET_RESOURCES_URL = 'testdata/search.json',

        // 自动完成关键字
        GET_KEYWORDS_URL = 'testdata/autocomplate.json',

        // 关键字获取
        GET_KEYWORDS_URL = 'testdata/hot.json'

    function getResourcesData(pageSize, pageIndex, params, callback) {

        ajaxHandler.select(GET_RESOURCES_URL, $.extend({
            'pageSize': pageSize,
            'page': pageIndex || 1,
        }, params), function(data) {

            callback(data.content, data.totalRecord)
        })
    }

    function getKeywords(pageSize, pageIndex, params, callback) {

        ajaxHandler.select(GET_KEYWORDS_URL, $.extend({
            'pageSize': pageSize,
            'page': pageIndex || 1,
        }, params), function(data) {

            callback(data.content, data.totalRecord)
        })
    }

    return {
        'search': function(pageSize, pageIndex, keyword, callback) {

            var params = {
                'keyWord': keyword
            }

            getResourcesData(pageSize, pageIndex, params, callback)
        },
        'getHot': function(pageSize, pageIndex, callback) {

            var params = {
                'sortType': 'hot'
            }

            getKeywords(pageSize, pageIndex, params, callback)
        }
    }
}