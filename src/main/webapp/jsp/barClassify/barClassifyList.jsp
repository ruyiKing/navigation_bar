<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>导航分类列表</title>
	<link rel="stylesheet" type="text/css" href="/js/easyui-1.4.4/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/js/easyui-1.4.4/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/js/easyui-1.4.4/themes/color.css">
    <link rel="stylesheet" type="text/css" href="/js/easyui-1.4.4/demo/demo.css">
    <script type="text/javascript" src="/js/jquery1.11.3.min.js"></script>
    <script type="text/javascript" src="/js/easyui-1.4.4/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout"  style="margin: 20px;">

<!-- style="margin:20px 0;text-align: right;" -->
	<div style="margin-bottom: 20px;margin-top: 50px;" >
		<form action="<%=request.getContextPath() %>/user/finduserList.do" method="post" id="queryForm" name="queryForm">
			<table>
				<%--<input type="text" name="queryUserName" id="queryUserName"  style="margin: 20px;" class="easyui-textbox" value="">--%>
				<a href="#" id="onclick" style="margin: 20px;" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" onclick="doSearch()">查询</a>
			</table>
		</form>
	</div>

	<div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="createBarClassify()">新建导航分类</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editBarClassify()">编辑导航分类</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyBarClassify()">删除导航分类</a>
    </div>
        
    <table id="dg" title="导航分类列表" class="easyui-datagrid" style="width:100%;height:365px;"
            url="<%=request.getContextPath() %>/barClassify/findBarClassifyList.do"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="id" width="50">序号</th>
                <th field="classifyName" width="50">导航类别名称</th>
                <th field="dateCreated" width="50">创建日期</th>
            </tr>
        </thead>
    </table>
   
    <!-- 新增、 更新 -->
    <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"  closed="true" buttons="#dlg-buttons">
        <div class="ftitle">导航类别</div>
        <form id="fm" method="post" novalidate>            
            <div class="fitem">
                <label>导航类别名称:</label>
                <input name="classifyName" class="easyui-textbox" required="true">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="save()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
    <script type="text/javascript">
    
	    $(function(){
	    	$('#queryUserName').textbox('textbox').keydown(function (e) {
                if (e.keyCode == 13) {
                	doSearch();
                }
            });
	    });
	    //查询
    	function doSearch(value){
    		var params = $('#dg').datagrid('options').queryParams; //先取得 datagrid 的查询参数  
            var fields =$('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象  
            $.each( fields, function(i, field){  
                params[field.name] = field.value; //设置查询参数  
            });   
            $('#dg').datagrid('reload'); //设置好查询参数 reload 一下就可以了  
	    }

        var url;
        //新增
        function createBarClassify(){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','新建导航分类');
            $('#fm').form('clear');
            url = '<%=request.getContextPath() %>/barClassify/saveBarClassify.do';
        }
        //修改
        function editBarClassify(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('center').dialog('setTitle','编辑导航分类');
                $('#fm').form('load',row);
                url = 'update_user.php?id='+row.id;
            }
        }
        function save(){
            $('#fm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.errorMsg){
                        $.messager.show({
                            title: 'Error',
                            msg: result.errorMsg
                        });
                    } else {
                        $('#dlg').dialog('close');        // close the dialog
                        $('#dg').datagrid('reload');    // reload the user data
                    }
                }
            });
        }
        function destroyBarClassify(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
                    if (r){
                        $.post('destroy_user.php',{id:row.id},function(result){
                            if (result.success){
                                $('#dg').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: result.errorMsg
                                });
                            }
                        },'json');
                    }
                });
            }
        }
    </script>
    <style type="text/css">
        #fm{
            margin:0;
            padding:10px 30px;
        }
        .ftitle{
            font-size:14px;
            font-weight:bold;
            padding:5px 0;
            margin-bottom:10px;
            border-bottom:1px solid #ccc;
        }
        .fitem{
            margin-bottom:5px;
        }
        .fitem label{
            display:inline-block;
            width:80px;
        }
        .fitem input{
            width:160px;
        }
    </style>
    
</body>
</html>