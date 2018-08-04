<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<table width="100%" height="15px" border="0" cellpadding="0" cellspacing="0" style="color:white;"
                  class="table_padding">
               <tr>
                   <td width="120px" class="font_left" >共&nbsp;<span id="total"></span>&nbsp;个资源</td>
                   <!-- <td width="12" class="font_left">第</td>
                   <td width="135" class="font_left">
                       <input id="pageNo" type="text" size="2" maxlength="4"/> /<span id="pageCount"></span> 页
                   </td> -->
                   <!-- <td class="font_left">
                   	<select id="pageSize" onchange="displayData(0);">
                   		<option value="2">每页2条</option>
                   		<option value="3">每页3条</option>
                   		<option value="4">每页4条</option>
                   		<option value="5">每页5条</option>
                   	</select>
                   </td> -->
                   <td class="font_right">
                       <div style="margin-left:20px" id="pagination"></div>
                   </td>
                   <!-- <td class="font_left">
                       <a href="javascript:void(0);" onclick="displayData(0);">刷新</a>
                   </td>  -->
               </tr>
       </table>