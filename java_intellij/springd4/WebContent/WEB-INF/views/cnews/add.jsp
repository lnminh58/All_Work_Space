<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <div class="left">
        <h2>Đăng tin</h2>
       <%--  <form:errors path="news1.*"></form:errors> <!--trong news có bn lỗi thì hiển thi ra hết  --> --%>
        <form action="#" method="post" enctype="multipart/form-data" id="contactform">
          <ol>
            <li>
              <label for="name">Tên tin*</label>
              <input id="name" name="name" class="text" />
              <form:errors path="news1.name"></form:errors>
            </li>
            <li>
              <label for="preview_text">Mô tả*</label>
              <textarea id="preview_text" name="description" rows="6" cols="50" class="text"></textarea>
              <form:errors path="news1.description"></form:errors>
            </li>
            
            <li>
              <label for="detail_text">Chi tiết*</label>
              <textarea id="detail_text" name="detail" rows="10" cols="50" class="text"></textarea>
               <form:errors path="news1.detail"></form:errors>
            </li>
             <li>
              <label for="name">hình ảnh mô tả</label>
              <input type="file"  name="hinhanh" />
            </li>
            
            <li class="buttons">
              <input type="submit" name="imageField" id="imageField"  value="Đăng tin" class="send" />
              <div class="clr"></div>
            </li>
          </ol>
        </form>
      </div>
      
      
  ''