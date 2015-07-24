var grid_tool_datagridID = 'dg';
var editIndex = undefined;

//结束编辑状态
function endEditing(id) {
    grid_tool_datagridID = id ? id : grid_tool_datagridID;

    if (editIndex == undefined) { return true }
    if ($('#' + grid_tool_datagridID).datagrid('validateRow', editIndex)) {
        $('#' + grid_tool_datagridID).datagrid('endEdit', editIndex);
        editIndex = undefined;
        return true;
    } else {
        return false;
    }
}

//进入编辑状态
function onClickRow(index) {
    if (editIndex != index) {
        reject(grid_tool_datagridID);
        $('#' + grid_tool_datagridID).datagrid('selectRow', index)
                .datagrid('beginEdit', index);
        editIndex = index;
    }
}

//取消
function reject(id) {
    grid_tool_datagridID = id ? id : grid_tool_datagridID;

    $('#' + grid_tool_datagridID).datagrid('rejectChanges');
    editIndex = undefined;
}

//新增一条待填数据行
function append(id, row) {
    grid_tool_datagridID = id ? id : grid_tool_datagridID;

    if (editIndex != undefined && $('#' + grid_tool_datagridID).datagrid('getRows', editIndex).id == undefined) {
        return;
    }

    if (endEditing()) {
        $('#' + grid_tool_datagridID).datagrid('insertRow', {
            index: 0,
            row: row
        });
        editIndex = 0;
        $('#' + grid_tool_datagridID).datagrid('selectRow', editIndex)
                .datagrid('beginEdit', editIndex);
    }
}

//删除
function removeit(id) {
    grid_tool_datagridID = id ? id : grid_tool_datagridID;

    var $dg = $('#' + grid_tool_datagridID);

    if (editIndex != undefined) {
        $dg.datagrid('cancelEdit', editIndex);
        editIndex = undefined;
    }

    var rows = $dg.datagrid('getChecked');

    var arrID = [];
    for (var i = 0; i < rows.length; i++) {
        arrID.push(rows[i].id);
    }

    while (rows.length > 0) {
        $dg.datagrid('deleteRow', $dg.datagrid('getRowIndex', rows[rows.length - 1]));
    }

    return arrID;
}
