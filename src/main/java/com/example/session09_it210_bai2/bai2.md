Phần 1 : Phân tích logic
Giải thích tại sao đoạn check if (guestName == null) ở bên trong hàm lại hoàn toàn vô dụng và không bao giờ được chạy tới trong trường hợp khách truy cập lần đầu?
- Vì : 
- trong CookieValue chưa có đặt requỉed  nên nó mặc định required = true;
- @CookieValue("guest_name") yêu cầu cookie guest_name phải tồn tại trong request nên nếu  khách truy cập lần đầu, trình duyệt chưa có cookie này 
-> sping cho lỗi khi mà chưa chạy if 