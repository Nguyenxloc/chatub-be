<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <script src="js/main.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <title>Document</title>
</head>

<body>
<header>
    <nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#"><strong>NEXTCOP</strong></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/Home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/Home/employee">Employee</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/Home/contactServlet">Contacts</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/Home/loginServlet">Login</a>
                    </li>
                </ul>
                <form class="d-flex" role="search">
                    <input class="form-control bg-light me-2" style="border:none" type="search"
                           placeholder="Tìm kiếm" aria-label="Tìm kiếm">
                    <button type="button" class="btn btn-danger">Search</button>
                </form>
            </div>
        </div>
    </nav>
</header>
<!-- <div class="col-f" style="width:700px;margin-left: auto;margin-right: auto;"> -->
<main>
    <form action="update-chiTietSP" method=post>
        <div class="card bg-light text-white" style="height: 900px">
            <div class="card-img-overlay">
                <h5 class="card-title" style="color:darkblue; text-align: center; font-size: 36px;">Quản lý chi tiết sản
                    phẩm
                </h5>
                <div class="d-flex justify-content-center bg-white"
                     style="margin-left: auto;margin-right:auto;max-width:1280px">
                    <div class="form bg-white m-auto" style="color:black;width:1280px;padding:56px;">
                        <div class="row">
                            <div class="col-md-4 fw-bold mb-3" style="color:darkblue;font-size: 20px;">
                                <i class="bi bi-square-fill me-2" style="color:#f26522"></i>
                                Chi tiết sản phẩm id:
                            </div>
                            <div class="col-md-4 fw-bold mb-3" style="color:darkblue;font-size: 20px;">
                                <div class="input-group mb-2">
                                    <input type="text" class="form-control" placeholder=""
                                           aria-label="Username" aria-describedby="basic-addon1" name="idInp" value ="${chiTietSP.idChiTietSP}" readonly>
                                </div>
                            </div>
                            <div class="col-md-4 fw-bold mb-3" style="color:darkblue;font-size: 20px;">

                            </div>
                            <div class="col-xxl-3 col-xl-6 col-md-12 mb-2">
                                <label class="gfield_label fw-semibold" style="color:#374151;font-size: 14px;"
                                >Sản phẩm</label>
                                    <select class="form-select" aria-label="Default select example" name="sanPhamInp">
                                        <c:forEach varStatus="i" items="${lstSanPham}" var="sanPham">
                                            <option value="${sanPham.idSanPham}" <c:if test="${chiTietSP.sp.idSanPham == sanPham.idSanPham}">selected </c:if>
                                            >${sanPham.ten} - ${sanPham.ma}</option>
                                        </c:forEach>
                                    </select>
                            </div>
                            <div class="col-xxl-3 col-xl-6 col-md-12 mb-2">
                                <label class="gfield_label fw-semibold" style="color:#374151;font-size: 14px;"
                                >Nơi sản xuất</label>
                                <select class="form-select" aria-label="Default select example" name="nsxInp">
                                    <c:forEach varStatus="i" items="${lstNSX}" var="nsx">
                                        <option value="${nsx.idNSX}" <c:if test="${chiTietSP.nsx.idNSX == nsx.idNSX}">selected</c:if>
                                        >${nsx.ten} - ${nsx.ma}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-xxl-3 col-xl-6 col-md-12 mb-2">
                                <label class="gfield_label fw-semibold" style="color:#374151;font-size: 14px;"
                                >Màu sắc</label>
                                <select class="form-select" aria-label="Default select example" name="mauSacInp">
                                    <c:forEach varStatus="i" items="${lstMauSac}" var="mauSac">
                                        <option value="${mauSac.idMauSac}" <c:if test="${chiTietSP.mauSac.idMauSac == mauSac.idMauSac}">selected</c:if>
                                        >${mauSac.ten} - ${mauSac.ma}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-xxl-3 col-xl-6 col-md-12 mb-2">
                                <label class="gfield_label fw-semibold" style="color:#374151;font-size: 14px;"
                                >Dòng sản phẩm</label>
                                <select class="form-select" aria-label="Default select example" name="dongSPInp">
                                    <c:forEach varStatus="i" items="${lstDongSP}" var="dongSP">
                                        <option value="${dongSP.idDongSP}" <c:if test="${chiTietSP.dongSP.idDongSP == dongSP.idDongSP}">selected</c:if>
                                        >${dongSP.ten} - ${dongSP.ma}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-xxl-3 col-xl-6 col-md-12 mb-2">
                                <label class="gfield_label fw-semibold" style="color:#374151;font-size: 14px;"
                                >Năm bảo hành</label>
                                <div class="input-group mb-2">
                                    <input type="number" class="form-control" placeholder=""
                                           aria-label="Username" aria-describedby="basic-addon1" name="namBHInp" value = "${chiTietSP.namBH}">
                                </div>
                            </div>
                            <div class="col-xxl-3 col-xl-6 col-md-12 mb-2">
                                <label class="gfield_label fw-semibold" style="color:#374151;font-size: 14px;"
                                >Mô tả</label>
                                <div class="input-group mb-2">
                                    <input type="text" class="form-control" placeholder=""
                                           aria-label="Username" aria-describedby="basic-addon1" name="motaInp" value ="${chiTietSP.mota}">
                                </div>
                            </div>
                            <div class="col-xxl-3 col-xl-6 col-md-12 mb-2">
                                <label class="gfield_label fw-semibold" style="color:#374151;font-size: 14px;"
                                >Số lượng tồn</label>
                                <div class="input-group mb-2">
                                    <input type="text" class="form-control" placeholder=""
                                           aria-label="Username" aria-describedby="basic-addon1" name="soLuongTonInp" value = "${chiTietSP.soLuongTon}">
                                </div>
                            </div>
                            <div class="col-xxl-3 col-xl-6 col-md-12 mb-2">
                                <label class="gfield_label fw-semibold" style="color:#374151;font-size: 14px;"
                                >Giá nhập</label>
                                <div class="input-group mb-3">
                                    <input type="text" class="form-control" placeholder="" aria-label=""
                                           aria-describedby="basic-addon1" name="giaNhapInp" value = "${chiTietSP.giaNhap}">
                                </div>
                            </div>
                            <div class="col-xxl-3 col-xl-6 col-md-12 mb-2">
                                <label class="gfield_label fw-semibold" style="color:#374151;font-size: 14px;"
                                >Giá bán</label>
                                <div class="input-group mb-3">
                                    <input type="text" class="form-control" placeholder="" aria-label=""
                                           aria-describedby="basic-addon1" name="giaBanInp" value ="${chiTietSP.giaBan}">
                                </div>
                            </div>

                            <div class="text-center ">
                                <br><br><br>
                                <button type="submit" class="btn btn-primary" style="border-radius:0%;">Cập nhật
                                </button>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</main>
<footer id="footer" style="margin-top: 60px;">
    <div class="container">
        <div class="row" style="width:750px;margin-left: auto;margin-right: auto;">
            <div class="col-4 md-4">
                <div class="useful-link">
                    <h2 style="color:white;">Useful Links</h2>
                    <div class="use-links">
                        <li><a href=""><i class="fa-solid fa-angles-right"></i> Home</a></li>
                        <li><a href=""><i class="fa-solid fa-angles-right"></i> About Us</a>
                        </li>
                        <li><a href=""><i class="fa-solid fa-angles-right"></i> Gallery</a>
                        </li>
                        <li><a href=""><i class="fa-solid fa-angles-right"></i> Contact</a>
                        </li>
                    </div>
                </div>
            </div>
            <div class="col-4 md-4">
                <div class="social-links">
                    <h2 style="color: white;">Follow Us</h2>
                    <div class="social-icons">
                        <li><a href=""><i class="fa-brands fa-facebook-f"></i> Facebook</a></li>
                        <li><a href=""><i class="fa-brands fa-instagram"></i> Instagram</a></li>
                        <li><a href=""><i class="fa-brands fa-linkedin-in"></i> Linkedin</a></li>
                    </div>
                </div>
            </div>
            <div class="col-4 md-4">
                <div class="address">
                    <h2 style="color: white">Address</h2>
                    <div class="address-links">
                        <li class="address1"><i class="fa-solid fa-location-dot"></i>FPT
                            Nam Từ Liêm-
                            Hà Nội
                            Việt Nam
                        </li>
                        <li><a href=""><i class="fa-solid fa-phone"></i> +84374223222</a></li>
                        <li><a href=""><i class="fa-solid fa-envelope"></i> phucloc@gmail.com</a></li>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
</body>
</html>