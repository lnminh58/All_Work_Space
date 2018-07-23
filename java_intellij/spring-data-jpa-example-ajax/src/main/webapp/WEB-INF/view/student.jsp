<%--
  Created by IntelliJ IDEA.
  User: lnminh
  Date: 2018-07-07
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- Khong co cai duoi khong chay dc cai tren --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css"
          integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
</head>
<body>


<div class="container mt-5">


    <button type="button" class="btn btn-primary mb-5 " data-toggle="modal" data-target="#form-modal">
        Add New Student
    </button>

    <div id="respond-success" class="alert alert-success d-none">
        ACTION SUCCESS!!!!!!!!!
    </div>
    <table id="student-list" class="table text-center mb-5">
        <thead class="thead-dark">
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Birthday</th>
            <th>Batch</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody id="table-body">
        <c:forEach items="${studentPage.content}" var="student">
            <tr>
                <td>${student.fullName}</td>
                <td>${student.age}</td>
                <td>
                    <c:choose>
                        <c:when test="${student.gender==true}">
                            <i class="fa fa-2x fa-male"></i>
                        </c:when>
                        <c:otherwise>
                            <i class="fa fa-2x fa-female"></i>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${student.birthday}</td>
                <td>${student.batch.batchName}</td>
                <td>
                    <button id="delete-${student.id}" class="btn btn-danger delete-student"
                            data-item-id="${student.id}">delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav class="paging" id="paging">
        <ul class="pagination text-primary">
            <li class="page-item ${studentPage.hasPreviousPage()==true?"":"disabled"} ">
                <a class="page-link" id="page-previous">previous</a>
            </li>

            <c:forEach begin="1" end="${studentPage.totalPages}" var="page">
                <li class="page-item ${studentPage.number+1 == page?"active text-white":""}">
                    <a class="page-link" id="page-${page}">${page}</a>
                </li>
            </c:forEach>

            <li class="page-item  ${studentPage.hasNextPage()==true?"":"disabled"}">
                <a class="page-link" id="page-next">Next</a>
            </li>
        </ul>
    </nav>


    <!-- Modal -->
    <div class="modal fade" id="form-modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">New Student</h5>
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form id="add-student-form">
                    <div class="modal-body">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text px-4"><i class="fa fa-user"></i></span>
                            </div>
                            <input type="text" class="form-control" id="stName" placeholder="Student Name"/>
                        </div>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text px-4"><i class="fa fa-birthday-cake"></i></span>
                            </div>
                            <input type="date" class="form-control" id="stBirthday">
                        </div>

                        <div class="form-check mb-3">
                            <input type="checkbox" class="form-check-input" id="stGender">
                            <label class="form-check-label" for="stGender">Male</label>
                        </div>

                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="batch">Batch</label>
                            </div>
                            <select class="custom-select" id="batch">
                                <c:forEach items="${batchs}" var="batch">
                                    <option value="${batch.id}">${batch.batchName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer text-center">

                        <button type="submit" class="btn btn-primary btn-block">Add</button>
                    </div>
                </form>
            </div>
        </div>
    </div>


</div>

<script
        src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script>

    $(document).ready(function () {
        requestAdd();
        requestDelete();
        requestGoToPage();
    });


    function requestGoToPage() {
        $(".page-link").on('click', function (event) {
            var data = prepareDataBeforeChangePage(event);
            console.log(data);
            createGoToPageAjax(data);
        })
    }

    function prepareDataBeforeChangePage(event) {
        var strRequestPageNumber = event.target.id;
        var strCurrentPageNumber = $('li.active > a').attr('id');
        var requestParams = "strRequestPageNumber=" + strRequestPageNumber + "&" + "strCurrentPageNumber=" + strCurrentPageNumber;
        return requestParams;
    }

    function createGoToPageAjax(data) {
        $.ajax({
            Type: "GET",
            url: "${pageContext.request.contextPath}/student/page",
            data: data,
            success: function (studentPage) {
                console.log(studentPage)
                renderStudentTable(studentPage);
                updatePagingBar(studentPage);
            }
        })
    }

    function renderStudentTable(studentPage) {
        var tableBody = $('#table-body');
        tableBody.children().remove();
        studentPage.content.forEach(function (student) {
            renderStudentRow(student);
        });
    }

    function updatePagingBar(studentPage) {
        if(studentPage.lastPage===true){
            $('#page-next').parent().addClass("disabled");
            $('#page-previous').parent().removeClass("disabled");
        }else if(studentPage.firstPage===true){
            $('#page-next').parent().removeClass("disabled");
            $('#page-previous').parent().addClass("disabled");
        }else {
            $('#page-next').parent().removeClass("disabled");
            $('#page-previous').parent().removeClass("disabled");
        }

        $('li.active').removeClass('active text-white');
        var currentPage = "#page-"+(studentPage.number+1);
        $(currentPage).parent().addClass('active text-white');

    }

    function requestAdd() {
        $("#add-student-form").submit(function (event) {
            event.preventDefault();
            var formData = hanldeAddFormSubmit();
            creatAddStudentAjax(formData);
        })
    }

    function hanldeAddFormSubmit() {
        var name = $("#stName").val();
        var birthday = $("#stBirthday").val();
        var gender = $("#stGender").is(":checked");
        var batchId = $("#batch").val();
        var formData = convertFormDataToJSON(name, gender, birthday, batchId);
        console.log(formData);
        return formData;
    }

    function convertFormDataToJSON(name, gender, birthday, batchId) {
        return JSON.stringify(
            {
                'fullName': name,
                'gender': gender,
                'birthday': birthday,
                'batchId': batchId
            }
        );
    }

    function creatAddStudentAjax(formData) {
        $.ajax({
            type: 'POST',
            url: "${pageContext.request.contextPath}/student/add",
            contentType: "application/json",
            data: formData,
            success: function (dataStudent) {
                renderStudentRow(dataStudent);
                saySucccess();
                hideModal();
            }
        })
    }

    function renderStudentRow(dataStudent) {
        if (dataStudent == null) {
            return;
        }
        var row = $("<tr>");

        var tdName = $("<td>");
        tdName.text(dataStudent.fullName);
        var tdAge = $("<td>");
        tdAge.text(dataStudent.age);
        var tdGender = $("<td>");
        if (dataStudent.gender === true) {
            tdGender.html('<i class=\'fa fa-2x fa-male\'></i>')
        } else {
            tdGender.html("<i class='fa fa-2x fa-female'></i>");
        }
        var tdBirthday = $("<td>");
        tdBirthday.text(dataStudent.birthday);
        var tdBatch = $("<td>");
        tdBatch.text(dataStudent.batch.batchName);
        var tdDeleteButton = $("<td>");
        var deleteButton = $("<button>");
        deleteButton.attr({
            id: "delete" + dataStudent.id,

        });
        deleteButton.attr('data-item-id', dataStudent.id);
        deleteButton.addClass('btn btn-danger delete-student');
        deleteButton.text('delete');
        tdDeleteButton.append(deleteButton);

        row.append(tdName);
        row.append(tdAge);
        row.append(tdGender);
        row.append(tdBirthday);
        row.append(tdBatch);
        row.append(tdDeleteButton);
        $("#table-body").append(row);
    }

    function hideModal() {
        $('#form-modal').modal('hide');
    }

    function requestDelete() {
        $("#student-list").on('click', '.delete-student', function (event) {
            var id = $(event.target).data("itemId");
            var data = JSON.stringify({"id": id});
            var rowId = "#" + event.target.id;
            console.log("into: delete event");
            createDeleteStudentAjax(data, rowId)
        });
    }

    function createDeleteStudentAjax(data, rowId) {
        $.ajax({
            type: 'DELETE',
            url: "${pageContext.request.contextPath}/student/delete",
            contentType: "application/json",
            data: data,
            success: function (data) {
                removeFromTableStudent(data, rowId);
                saySucccess();
            }
        });
    }

    function removeFromTableStudent(data, rowId) {
        $(rowId).closest("tr").remove();

    }

    function saySucccess() {
        $("#respond-success").removeClass("d-none");
        setTimeout(
            function () {
                $("#respond-success").addClass("d-none");
            }
            , 2000);
    }

</script>

</body>
</html>
