<%@page pageEncoding="UTF-8" language="java"  isELIgnored="false" %>
<script>
    //显示所有信息
    $(function () {
        $("#mv").treegrid({

            url:"${pageContext.request.contextPath}/album/All",
            idField:'id',
            treeField:'title',
            animate:true,
            /* pagination:false,//显示分页工具栏
             pageName:1,
             pageSize:5,
             pageList:[2,5,10,15,20],*/
              striped:true,
              singleSelect:false,
              ctrlSelect:true,
              remoteSort:false,
              multiSort:true,
            columns:[[
                {title:'id',field:'id',width:250},
                {title:'名字',field:'title',width:250},
                {title:'章节大小',field:'sizes',width:250},
                {title:'章节时长',field:'duration',width:250},
                {title:'下载路径',field:'downPath',width:250}, //sortable:true排序
                /*,
            /*  {title: '其他', field: 'options', width: 200,
                formatter: function (value, row, index) {
                     return "<a href='javascript:;' class='options' onclick=\"delRow('" + row.id + "')\" data-options=\"iconCls:'icon-delete',plain:true\">删除</a>&nbsp;&nbsp;&nbsp;" +
                         "<a href='javascript:;' class='options' onclick=\"openEdit('" + row.id + "')\" data-options=\"iconCls:'icon-edit',plain:true\">修改</a>";
                 }
                }*/
            ]],


    });
    });
    //打开保存专辑对话框函数
    function openAlbumAdd() {
        $("#saveAlbumInsert").dialog({
            buttons:[{
                iconCls: 'icon-add',
                text: '保存专辑',
                handler: function () {
                    //保存用户信息
                    $("#openAlbumSave").form('submit', {
                        url: '${pageContext.request.contextPath}/album/add',
                        success: function (result) {//响应的一定是json格式字符串  使用应该先转为js对象
                            var resultObj=$.parseJSON(result);
                            if (resultObj.success) {
                                //提示信息
                                $.messager.show({title: '提示', msg: "添加专辑成功!!!"});
                            }else {
                                $.messager.show({title:'提示',msg:"添加专辑失败!!!"});
                           }
                            //关闭对话框
                            $("#saveAlbumInsert").dialog('close');
                            //刷新treegrid
                            $("#mv").treegrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function () {
                    $("#saveAlbumInsert").dialog('close');
                }
            }]
        });
    }
    //添加章节
    function openChapterAdd() {
        $("#saveChapterInsert").dialog({
            buttons:[{
                iconCls: 'icon-add',
                text: '保存章节',
                handler: function () {
                    //保存用户信息
                    $("#openChapterSave").form('submit', {
                        url: '${pageContext.request.contextPath}/chapter/add',
                        success: function (result) {//响应的一定是json格式字符串  使用应该先转为js对象
                            var resultObj=$.parseJSON(result);
                            if (resultObj.success) {
                                //提示信息
                                $.messager.show({title: '提示', msg: "添加章节成功!!!"});
                            }else {
                                $.messager.show({title:'提示',msg:"添加章节失败"});
                            }
                            //关闭对话框
                            $("#saveChapterInsert").dialog('close');
                            //刷新dategrid
                            $("#mv").treegrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function () {
                    $("#saveChapterInsert").dialog('close');
                }
            }]
        });
    }
    //详细专辑
    function openAlbumFindOne() {
        var jQuery = $("#mv").treegrid('getSelected');
        var s = JSON.stringify(jQuery);
        var id = jQuery.id;
        $("#findOneAlbum").dialog({
            href:'${pageContext.request.contextPath}/xiangguan/main/findOneAlbum.jsp?jQuery='+s,
            buttons:[{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function () {
                    $("#findOneAlbum").dialog('close');
                }
            }]
        });
    }
    //下载
    function upLoad() {
        var jQuery = $("#mv").treegrid('getSelected');
        /*var s = JSON.stringify(jQuery);*/
        var downPath = jQuery.downPath;

        location.href="${pageContext.request.contextPath}/upLoad/download?fileName="+downPath+"&openStyle=attachment";
    }




</script>

<table id="mv">

    <div id="tb">
    <a href="#" class="easyui-linkbutton" onclick="openAlbumAdd();" data-options="iconCls:'icon-add',plain:true">添加专辑</a>
    <a href="#" class="easyui-linkbutton" onclick="openChapterAdd();" data-options="iconCls:'icon-add',plain:true">添加章节</a>
    <a href="#" class="easyui-linkbutton" onclick="openAlbumFindOne();" data-options="iconCls:'icon-book',plain:true">专辑详细信息</a>
    <a href="#" class="easyui-linkbutton" onclick="upLoad();" data-options="iconCls:'icon-book',plain:true">下载章节</a>

</div>

    <%--对话框--%>
    <div id="saveAlbumInsert" data-options="href:'${pageContext.request.contextPath}/xiangguan/main/saveAlbum.jsp',draggable:false,iconCls:'icon-save',width:600,height:500,title:'保存专辑'"></div>
    <div id="saveChapterInsert" data-options="href:'${pageContext.request.contextPath}/xiangguan/main/saveChapter.jsp',draggable:false,iconCls:'icon-save',width:500,height:300,title:'保存章节'"></div>
    <div id="findOneAlbum"  data-options="draggable:false,iconCls:'icon-save',width:500,height:350"></div>

</table>