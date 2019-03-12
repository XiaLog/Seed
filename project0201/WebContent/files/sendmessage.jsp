<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>项目管理系统 by www.eyingda.com</title>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />

<script src="../js/jquery-1.11.1.js"></script>
<script language="JavaScript" type="text/javascript">
function tishi()
{
  var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
  if(a!=true)return false;
  window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check()
{
document.getElementById("aa").style.display="";
}

</script>

<script>
  $(function(){
	 $.getJSON("emp.do",{},function(data){
		 var tab=($("<table>"));
		 $("#div_list").append(tab);
		 var tr=null;
		 $.each(data,function(i,d){
			if(i%5==0){
				tr=$("<tr>");
                tab.append(tr);
			} 
			var td=$("<td>");
			var cb=$("<input type='checkbox' name='eid'>").val(d.empid);
			td.append(cb);
			cb.click(function(){
				var names=[];
				 $("input:checked").each(function(){
					 names.push($(this).next().html());
				 });
				 $("#get_name").val(names.join(";"));
			 });
			td.append($("<span>").html(d.empname));
			tr.append(td);
         });
		 var trr=$("<tr>");
		 var tdd=$("<td colspan='5' align='right'>");
		 tdd.append($("<input type='button' value='提交' id='btu'>"));
		 trr.append(tdd);
		 tab.append(trr);
		 $("#btu").click(function(){
			 $("#div_list").fadeOut();
		 }); 
	 });
	 
	 $("#get_name").focus(function(){
		 $("#div_list").fadeIn();
	 });
  });

</script>

<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="message.do" method="post" name="form" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >新建信息</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="button" name="Submit" value="发送" class="button" onclick="alert('发送成功！');"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
		</td></tr>
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>新建信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					    
					    
					  <tr>
					    <td nowrap align="right" width="11%">消息标题:</td>
					    <td width="27%"><input name="messagetitle" type="text" class="text" style="width:154px" value="" /></td>
				        	
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					    </tr>
					    
					    
					    
					  <tr>
					    <td width="11%" align="right" nowrap>接收者:</td>
					    <td colspan="3"><input name="empid" readonly="readonly" "text" class="text" style="width:450px;" size="20" value="" id="get_name" />
					      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="priority">
							<option selected="selected" value="1" >==选择==</option>
							<option value="1">低级</option>
							<option value="2">中级</option>
							<option value="3">高级</option>
						</select></td>
					    </tr>
					  
					  <tr>
					    <td  width="11%" nowrap align="right">信息内容:</td>
					    <td colspan="3"><textarea name="messagecontent" cols="100" rows="20"></textarea></td>
					    </tr>
					  </table>
					  
					  
					  
			  <br />
				</fieldset>			</TD>
			
		</TR>
		
		

		
		
		
		</TABLE>
	
	
	 </td>
  </tr>
  
  
		
		
		
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="Submit" value="发送" class="button" "/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  </table>
 
 <div style="background-color:gray; width:300px;height:100px;display:none;position:absolute;top:172px;left:145px"  id="div_list">			  
 </div>

</div>
</form>
</body>
</html>
