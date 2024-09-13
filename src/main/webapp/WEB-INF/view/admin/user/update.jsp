<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="Dự án laptopshop" />
    <meta name="author" content="Thời" />
    <title>Update User</title>
    <link href="/css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <script 
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(document).ready(() => {
            const avatarFile = $("#avatarFile");
            const orgImage = "${newUser.avatar}";
            if (orgImage) {
                const urlImage = "/images/avatar/" + orgImage;
                $("#avatarPreview").attr("src", urlImage);
                $("#avatarPreview").css({ "display": "block" });
            }

            avatarFile.change(function (e) {
                const imgURL = URL.createObjectURL(e.target.files[0]);
                $("#avatarPreview").attr("src", imgURL);
                $("#avatarPreview").css({ "display": "block" });
            });
        });
    </script>
</head>

<body class="sb-nav-fixed">
    <jsp:include page="../layout/header.jsp" />
    <div id="layoutSidenav">
    <jsp:include page="../layout/sidebar.jsp" />
      
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Manage Users</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                        <li class="breadcrumb-item active"><a href="/admin/user">Users</a></li>
                        <li class="breadcrumb-item">Update</li>
                    </ol>
                    <div class="mt-5">
                        <div class="row">
                            <div class="col-md-6 col-12 mx-auto">
                                <h3>Update a user</h3>
                                <hr />
                                <form:form method="post" action="/admin/user/update" modelAttribute="newUser"
                                enctype="multipart/form-data" >
                                    <div class="mb-3" style="display: none;">
                                        <label  class="form-label">Id:</label>
                                        <form:input type="text" path="id" class="form-control"  />
                                    </div>
                                    <div class="mb-3">
                                        <label  class="form-label">Email:</label>
                                        <form:input type="email" path="email" class="form-control" disabled="true" />
                                    </div>
                               
                                    <div class="mb-3">
                                        <label  class="form-label">Phone number:</label>
                                        <form:input type="text" path="phone" class="form-control" />
                                    </div>
                                    <div class="mb-3">
                                        <c:set var="errorFullName">
                                            <form:errors path="fullName" cssClass="invalid-feedback"/>
                                        </c:set>
                                        <label  class="form-label">Full name:</label>
                                        <form:input type="text" path="fullName" class="form-control ${not empty errorFullName ? 'is-invalid':'' }" />
                                        ${errorFullName}
                                    </div>
                                
                                    <div class="mb-3">
                                        <label  class="form-label">Address:</label>
                                        <form:input type="text" path="address" class="form-control" />
                                    </div>
                                    <div class="col-md-6  col-12">
                                        <label for="inputRole" class="form-label">Role:</label>
                                        <form:select id="inputRole" class="form-select"
                                            path="role.name">
                                            <c:choose>
                                                <c:when
                                                    test="${newUser.getRole().getName() eq 'ADMIN'}">
                                                    <option value="ADMIN" selected>Admin
                                                    </option>
                                                    <option value="USER">User</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="ADMIN">Admin</option>
                                                    <option value="USER" selected>User
                                                    </option>
                                                </c:otherwise>
                                            </c:choose>
                                        </form:select>
                                    </div>
                                    <div class="col-md-6  col-12">
                                        <label for="avatarFile" class="form-label">Avatar:
                                        </label>
                                        <input class="form-control" type="file" id="avatarFile"
                                            accept=".png, .jpg, .jpeg" name="imgFile" />
                                    </div>
                                    <div class="col-12 mt-3 ">
                                        <c:choose>
                                            <c:when test="${newUser.getAvatar() == null}">
                                                <img style="max-height: 250px; display: none;"
                                                    alt="avatar preview" id="avatarPreview" />
                                            </c:when>
                                            <c:otherwise>
                                                <img style="max-height: 250px; display: block;"
                                                    alt="avatar preview" id="avatarPreview"
                                                    src="images/avatar/${newUser.avatar}" />
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class="col-12 mb-5 mt-3">
                                        <button type="submit" class="btn btn-warning ">Update</button>
                                        <a href="/admin/user" type="button" class="btn btn-secondary mx-2">Cancel</a>
                                    </div>   
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        <jsp:include page="../layout/footer.jsp" />
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
    
</body>

</html>