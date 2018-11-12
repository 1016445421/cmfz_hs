<%@page pageEncoding="UTF-8" language="java"  isELIgnored="false" %>
<script>
    //显示所有信息
    $(function () {
        $("#lbt").datagrid({
            url:"${pageContext.request.contextPath}/banner/All",
            height:500,
             striped:true,
             singleSelect:false,
             ctrlSelect:true,
             remoteSort:false,
             multiSort:true,
            columns:[[
                {title:'名字',field:'title',width:200},
                {title:'路径',field:'imgPath',width:150},
                {title:'状态',field:'status',width:200},
                {title:'时间',field:'days',width:200,sortable:true}, //sortable:true排序
                {title: '其他', field: 'options', width: 200,
                    formatter: function (value, row, index) {
                        return "<a href='javascript:;' class='options' onclick=\"delRow('" + row.id + "')\" data-options=\"iconCls:'icon-delete',plain:true\">删除</a>&nbsp;&nbsp;&nbsp;" +
                            "<a href='javascript:;' class='options' onclick=\"openEdit('" + row.id + "')\" data-options=\"iconCls:'icon-edit',plain:true\">修改</a>";
                    }
                }
            ]],
            view: detailview,
                    detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/photo/bannerPic/' + rowData.imgPath + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>名字: ' + rowData.title + '</p>' +
                        '<p>状态: ' + rowData.status + '</p>' +
                        '<p>时间: ' + rowData.days + '</p>'+
                        '</td>' +
                        '</tr></table>';
            },
        onLoadSuccess:function () {
            $(".options").linkbutton();
        },
        toolbar:'#lbt',
    });
    });

    //修改信息
    function openEdit(id) {
        $("#UpdateOpenEdit").dialog({
            href:'${pageContext.request.contextPath}/xiangguan/main/editBanner.jsp?id='+id,
            buttons:[{
                    iconCls:'icon-edit',
                    text:'修改',
                    handler:function () {
                        $("#openBannerEdit").form('submit',{
                            url:'${pageContext.request.contextPath}/banner/motify',
                            success:function (result) {//注意一定是json字符串 使用需要转为js对象
                                //关闭dialog
                                $("#UpdateOpenEdit").dialog('close');
                                //刷新datagrid
                                $("#lbt").datagrid('reload');//刷新当前datagrid
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
                        $("#UpdateOpenEdit").dialog('close');
                    }
                },
            ]
        });
    }


    //删除一行
    function delRow(id) {
        $.post("${pageContext.request.contextPath}/banner/remove",{"id":id},function (result) {//响应成功之后回调
            //刷新dategrid数据
            $("#lbt").datagrid('reload');//刷新当前datagrid
        });
    }

    //打开用户保存对话框函数
    function openAdd() {
        $("#saveOpenInsert").dialog({
            buttons:[{
                iconCls: 'icon-add',
                text: '保存',
                handler: function () {
                    //保存用户信息
                    $("#openBannerSave").form('submit', {
                        url: '${pageContext.request.contextPath}/banner/add',
                        success: function (result) {//响应的一定是json格式字符串  使用应该先转为js对象
                            var resultObj=$.parseJSON(result);
                            if (resultObj.success) {
                                //提示信息
                                $.messager.show({title: '提示', msg: "添加成功!!!"});
                            }else {
                                $.messager.show({title:'提示',msg:resultObj.message});
                            }
                            //关闭对话框
                            $("#saveOpenInsert").dialog('close');
                            //刷新dategrid
                            $("#lbt").datagrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function () {
                    $("#saveOpenInsert").dialog('close');
                }
            }]
        });
    }

</script>

<table id="lbt">

<div id="tb">
    <a href="#" class="easyui-linkbutton" onclick="openAdd();" data-options="iconCls:'icon-add',plain:true">添加</a>
<%--    <a href="#" class="easyui-linkbutton" onclick="openUpdate();" data-options="iconCls:'icon-book',plain:true">保存</a>--%>
</div>

    <%--保存对话框--%>
    <div id="saveOpenInsert" data-options="href:'${pageContext.request.contextPath}/xiangguan/main/saveBanner.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'保存信息'"></div>

   <%--修改对话框--%>
    <div id="UpdateOpenEdit" data-options="draggable:false,iconCls:'icon-edit',width:500,height:400,title:'修改信息'">
    </div>

</table>