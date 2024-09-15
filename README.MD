                    Set up project laptopshop.vn
Java Spring MVC
Project thực hành: xây dựng website bán laptop với Java Spring
1.	Công nghệ sử dụng
Backend: (Java)
- Spring Boot : bootstrapping project
- Spring MVC : mô hình model-view-controller
- Spring Security: bảo vệ route với role (dạng basic)
- Spring Session: quản lý phiên đăng nhập của người dùng
- Spring Data  (Hibernate/JPA): sử dụng ORM (object relational mapping) để mô hình 
hóa Model
-  Phân tích database (ràng buộc relationship)
- Build tool:  Maven
Frontend: HTML, CSS và Javascript
- View Engine: JSP
Database: MySQL (phần mềm MySQL WorkBench)
2.	Dự án thực hành
Tạo một website bán laptop
Ý tưởng: có một trang web để hiển thị sản phẩm cho người dùng lựa chọn, các tính năng 
chính : 
-  Hiển thị danh sách sản phẩm (trang chủ /homepage)
-  Xem chi tiết 1 sản phẩm
-  Tìm kiếm sản phẩm theo tiêu chí (giá cả, số lượng, nhà sản xuất…)
-  Giỏ hàng
-  Thông báo mua thành công
Tham khảo: https://fptshop.com.vn/may-tinh-xach-tay
3.	Phân Tích Model cho dự án
dự án thực hành chia thành 2 loại chính:
1. Người dùng chưa đăng nhập (guest)
Có thể : 
-  Xem danh sách sản phẩm, xem chi tiết sản phẩm
-  Tìm kiếm sản phẩm theo tiêu chí
Không thể:
-  Đặt hàng (place order )
-  Thêm/sửa/xóa sản phẩm và thông tin trên website
2. Người dùng đã đăng nhập (user)
Phân chia theo vai trò của người dùng
Vai trò người dùng thông thường: (user)
-  Kế thừa lại các tính năng của Guest (người dùng chưa đăng nhập)
-  Có thể đặt hàng
-  Không có quyền hạn thêm/sửa/xóa sản phẩm và thông tin trên website
Vai trò người dùng quản trị: (admin)
-  Kế thừa lại các tính năng của User
-  Full quyền trong hệ thống
4. Thiết kế database
Link file excel : https://docs.google.com/spreadsheets/d/1X9JYIIiC5UNR322oK1TANe4gV7co8Zmu/edit?usp=sharing&ouid=108594858465212419873&rtpof=true&sd=true
