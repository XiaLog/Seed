<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>项目管理系统 by www.eyingda.com</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="../css/css.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">

</script>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}

function link(){
    document.getElementById("fom").action="empadd.jsp";
   document.getElementById("fom").submit();
}

</SCRIPT>

<body>
<form name="fom" id="fom" method="post" action="empdelete.do">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="../images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="24"><img src="../images/ico07.gif" width="20" height="18" /></td>
			  <td width="519"><select name="select2">
				    <option>按录入时间</option>
				    <option>按注销时间</option>
			      </select>
			   <input name="textfield" type="text" size="12" readonly="readonly"/><span class="newfont06">至</span>
			   <input name="textfield" type="text" size="12" readonly="readonly"/>	
			   <input name="Submit" type="button" class="right-button02" value="查 询" /></td>
			   <td width="679" align="left"><a href="#" onclick="sousuo()">
			     <input name="Submit" type="button" class="right-button07" value="高级搜索" />
			   </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>	
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="20"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
		           <input name="Submit" type="button" class="right-button08" value="删除所选人员信息" /> <input name="Submit" type="button" class="right-button08" value="添加人员信息" onclick="link();" />
		           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	              </td>
          </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="15" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 工资详细列表 &nbsp;</td>
                    </tr>
                  <tr>
				    <td width="6%" align="center" bgcolor="#EEEEEE">选择</td>
					 <td width="9%" height="20" align="center" bgcolor="#EEEEEE">唯一编号</td>
                    <td width="9%" align="center" bgcolor="#EEEEEE">真实姓名</td>
                    <td width="9%" align="center" bgcolor="#EEEEEE">职位</td>
					<td width="9%" align="center" bgcolor="#EEEEEE">员工类型</td>
					<td width="10%" align="center" bgcolor="#EEEEEE">省份证号码</td>
					<td width="4%" align="center" bgcolor="#EEEEEE">性别</td>
					<td width="4%" align="center" bgcolor="#EEEEEE">年龄</td>
					<td width="11%" align="center" bgcolor="#EEEEEE">出生年月</td>
					<td width="10%" align="center" bgcolor="#EEEEEE">联系电话</td>
                    <td width="19%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  
                  <c:forEach items="${list }" var="e">
                  <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid" value="${e.empid }"/></td>
					<td height="20" bgcolor="#FFFFFF"><a href="listyuangongmingxi.html">${e.empid }</a></td>
                    <td bgcolor="#FFFFFF"><a href="listyuangongmingxi.html">${e.empname }</a></td>
                    <td bgcolor="#FFFFFF">程序员</td>
                    <td bgcolor="#FFFFFF">${e.emptype }</td>
                    <td bgcolor="#FFFFFF">${e.idcard }</td>
					<td height="20" bgcolor="#FFFFFF">${e.sex }</td>
					<td height="20" bgcolor="#FFFFFF">22</td>
					<td height="20" bgcolor="#FFFFFF">${e.birth }</td>
					<td height="20" bgcolor="#FFFFFF">${e.tel }</td>
                    <td bgcolor="#FFFFFF"><a href="beforechange.do?empid=${e.empid }">编辑</a>&nbsp;|&nbsp;<a href="yuangongsalary.html">发工资</a></a>&nbsp;|&nbsp;<a href="yuangongxiangmu.html">项目</a></td>
                  </tr>
                  </c:forEach>
                  
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span class="right-text09">${pageinfo.pagecount }</span> 页 | 第 <span class="right-text09">${pageinfo.currentpage }</span> 页</td>
                <td width="49%" align="right">[<a href="javascript:return void(0)" class="right-font08" value="1">首页</a> |
                 <c:if test="${pageinfo.currentpage-1>0 }">
                <a href="javascript:return void(0)" class="right-font08" value=${pageinfo.currentpage-1 }>上一页</a> |
                </c:if>
                 <c:if test="${pageinfo.currentpage+1<=pageinfo.pagecount}">
                 <a href="javascript:return void(0)" class="right-font08" value=${pageinfo.currentpage+1 }>下一页</a> | 
                   </c:if>
                 <a href="javascript:return void(0)" class="right-font08" value=${pageinfo.pagecount }>末页</a>] 转至：</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%"><input name="textfield3" type="text" class="right-textfield03" size="1" /></td>
                      <td width="87%"><input name="Submit23222" type="submit" class="right-button06" value=" " />
                      </td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
<form action="${pageinfo.url }" method="post" id="pagecurrent">
        <input type="hidden" name="currentpage"  id="hi_page"/>
        </form>

<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<script type="text/javascript">
       $(function(){
    	  $(".right-font08").click(function(){

    		$("#hi_page").val($(this).attr("value"));
    		$("#pagecurrent").submit();
    	  }); 
    	  
    	  $(".right-button08").click(function(){
        		var check=$("input:checked");
        		if(check.size()==0)
        			alert("请选择要删除的信息");
        		if(confirm("确定删除所有选中信息？")){
        			$("#fom").submit()
        		}
        	});
 
       });
    </script>


</body>
</html>
