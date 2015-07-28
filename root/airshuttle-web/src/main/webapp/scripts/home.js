$(function() {

    $('#keyword').bigAutocomplete({
        "url": "testdata/autocomplate.json",
        "callback": function(data) {

            location.href = 'results.html?q=' + escape((data ? data.keyWord : $('#keyword').val()))
        }
    })

    // 搜索事件
    $('#search').click(function() {

        location.href = 'results.html?q=' + escape($('#keyword').val())
    })
})