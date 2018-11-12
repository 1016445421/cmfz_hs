<%@page pageEncoding="UTF-8" language="java"  isELIgnored="false" %>
<script>
    //显示所有信息
    $(function () {
        $("#ss").datagrid({
            url:"${pageContext.request.contextPath}/guru/All",
            pagination:false,//显示分页工具栏
            height:500,
            /* pageName:1,
             pageSize:5,
             pageList:[2,5,10,15,20],
             striped:true,
             singleSelect:false,
             ctrlSelect:true,
             remoteSort:false,
             multiSort:true,*/
            columns:[[
                {title:'Name',field:'name',width:200},
                {title:'HeadPic',field:'headPic',width:150},
                {title:'Sex',field:'sex',width:200},
                {title: '其他', field: 'options', width: 200,
                    formatter: function (value, row, index) {
                        return "<a href='javascript:;' class='options' onclick=\"guruDelRow('" + row.id + "')\" data-options=\"iconCls:'icon-delete',plain:true\">删除</a>&nbsp;&nbsp;&nbsp;" +
                            "<a href='javascript:;' class='options' onclick=\"guruOpenEdit('" + row.id + "')\" data-options=\"iconCls:'icon-edit',plain:true\">修改</a>";
                    }
                }
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/photo/teacher/' + rowData.headPic + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>名字: ' + rowData.name + '</p>' +
                    '<p>性别: ' + rowData.sex + '</p>'+
                    '</td>' +
                    '</tr></table>';
            },
        onLoadSuccess:function () {
            $(".options").linkbutton();
        },
        toolbar:'#ss',
    });
    });

    //修改信息
    function guruOpenEdit(id) {
        $("#openGuruEdit").dialog({
            href:'${pageContext.request.contextPath}/xiangguan/main/guruUpdate.jsp?id='+id,
            buttons:[{
                    iconCls:'icon-edit',
                    text:'修改',
                    handler:function () {
                        $("#GuruEdit").form('submit',{
                            url:'${pageContext.request.contextPath}/guru/motify',
                            success:function (result) {//注意一定是json字符串 使用需要转为js对象
                                //关闭dialog
                                $("#openGuruEdit").dialog('close');
                                //刷新datagrid
                                $("#ss").datagrid('reload');//刷新当前datagrid
                                //提示修改信息
                                $.messager.show({title:'提示',msg:"信息修改成功！！！"});
                            }
                        })
                    }
                },
                {
                    iconCls:'icon-reload',
                    text:'取消',
                    handler:function () {
                        $("#openGuruEdit").dialog('close');
                    }
                },
            ]
        });
    }


    //删除一行
    function guruDelRow(id) {
        $.post("${pageContext.request.contextPath}/guru/remove",{"id":id},function (result) {//响应成功之后回调
            //刷新dategrid数据
            $("#ss").datagrid('reload');//刷新当前datagrid
        });
    }

    //打开用户保存对话框函数
    function GuruAdd() {
        $("#GuruInsert").dialog({
            buttons:[{
                iconCls: 'icon-add',
                text: '保存',
                handler: function () {
                    //保存用户信息
                    $("#openGuruSave").form('submit', {
                        url: '${pageContext.request.contextPath}/guru/add',
                        success: function (result) {//响应的一定是json格式字符串  使用应该先转为js对象
                            var resultObj=$.parseJSON(result);
                            if (resultObj.success) {
                                //提示信息
                                $.messager.show({title: '提示', msg: "添加成功!!!"});
                            }else {
                                $.messager.show({title:'提示',msg:resultObj.message});
                            }
                            //关闭对话框
                            $("#GuruInsert").dialog('close');
                            //刷新dategrid
                            $("#ss").datagrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function () {
                    $("#GuruInsert").dialog('close');
                }
            }]
        });
    }

</script>

<table id="ss">

<div id="tb">
    <a href="#" class="easyui-linkbutton" onclick="GuruAdd();" data-options="iconCls:'icon-add',plain:true">添加</a>
   <%-- <a href="#" class="easyui-linkbutton" onclick="GuruUpdate();" data-options="iconCls:'icon-book',plain:true">保存</a>--%>
</div>

    <%--保存对话框--%>
    <div id="GuruInsert" data-options="href:'${pageContext.request.contextPath}/xiangguan/main/saveGuru.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'保存信息'"></div>

   <%--修改对话框--%>
    <div id="openGuruEdit" data-options="draggable:false,iconCls:'icon-edit',width:500,height:300,title:'修改信息'">
    </div>

</table>