<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" isErrorPage="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/xiangguan/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/xiangguan/themes/IconExtension.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/xiangguan/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/xiangguan/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/xiangguan/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/xiangguan/js/datagrid-detailview.js"></script>


    <script type="text/javascript">
        var l="${sessionScope.session}";
        if(l==''){
            location.href="${pageContext.request.contextPath}/xiangguan/login.jsp";
        }
	<!--菜单处理-->
    $(function () {
        //页面加载完成后显示菜单数据
        $.post("${pageContext.request.contextPath}/Menu/QA",function (menu) {
            //通过accordion的添加方法追加菜单
            console.log(menu);
            //遍历一级菜单
            $.each(menu,function (index,m) {
                //遍历二级菜单
                var content="<div style='text-align:center;'>";
                $.each(m.children,function (idx,child) {
                    content+="<a onclick=\"addTabs('"+child.title+"','"+child.iconCls+"','"+child.href+"')\" style='width:95%;margin:10px 0px;border:2px solid #c7ccd1;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\">"+child.title+"</a><br>";
                });
                content +="</div>"
                //添加菜单
                $("#menu").accordion('add',{
                    title:m.title,
                    iconCls:m.iconCls,
                    content:content,
                })
            });
        });
    });

    //点击菜单追加选项卡
    function addTabs(title,iconCls,href) {
        if(!$("#tabs").tabs('exists',title)){
            $("#tabs").tabs('add',{
                title:title,
                iconCls:iconCls,
                closable:true,
                fit:true,
                href:"${pageContext.request.contextPath}/"+href,
            });
        }else{
            $("#tabs").tabs('select',title);
        }
    }
    //打开修改用户的对话框
    function openUpdatePwdDialog(id) {

        $("#update1").dialog({
            title:'修改密码',
                width:500,
                 height:400,
            href:'${pageContext.request.contextPath}/xiangguan/main/edit.jsp?id='+id,
            buttons:[
                {
                    iconCls:'icon-edit',
                    text:'修改',
                    handler:function () {
                        $("#update2").form('submit',{
                            url:'${pageContext.request.contextPath}/admin/upd',
                            success:function (result) {//注意一定是json字符串 使用需要转为js对象
                                //关闭dialog
                                $("#update1").dialog('close');
                                //刷新datagrid
                                $("#dg").datagrid('reload');//刷新当前datagrid
                                //提示修改信息
                                $.messager.show({title:'提示',msg:"密码修改成功！！！"});
                            }
                        })
                    }
                },
                {
                    iconCls:'icon-reload',
                    text:'取消',
                    handler:function () {
                        $("#update").dialog('close');
                    }
                },
            ]
        });
    }

</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.session.name} &nbsp;<a onclick="openUpdatePwdDialog(${sessionScope.session.id})" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/over" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="menu" class="easyui-accordion" data-options="fit:true">
        </div>

    </div>

    <div data-options="region:'center'">
        <%--选项卡--%>
        <div id="tabs" class="easyui-tabs" data-options="fit:true,close:'which'">
            <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url('${pageContext.request.contextPath}/xiangguan/main/image/shouye.jpg');background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>
    </div>
<div id="update1" ></div>
</body> 
</html>