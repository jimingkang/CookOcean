function commentDatacontroller() {

    // AJAX 数据请求处理
    var ajaxHandler = ajaxDataController(),

        // 药品数据  
        GET_DRUGS_URL = 'testdata/drugs.json',

        // 药品信息
        GET_DRUG_URL = 'testdata/drug.json'

    function getDrugData(pageSize, pageIndex, params, callback) {

        ajaxHandler.select(GET_DRUGS_URL, $.extend({
            'pageSize': pageSize,
            'page': pageIndex || 1,
        }, params), function(data) {

            callback(data.content, data.totalRecord)
        })
    }

    return {
        'getNormalDrugs': function(pageSize, pageIndex, callback) {

            var params = {
                'tag': '家庭常用',
            }

            getDrugData(pageSize, pageIndex, params, callback)
        },
        'getDiseaseDrugs': function(pageSize, pageIndex, keyword, callback) {

            var params = {
                'keyWord': keyword,
            }

            getDrugData(pageSize, pageIndex, params, callback)
        },
        'getDrugs': function(pageSize, pageIndex, keyword, callback) {

            var params = {
                'keyWord': keyword,
            }

            getDrugData(pageSize, pageIndex, params, callback)
        }
    }
}