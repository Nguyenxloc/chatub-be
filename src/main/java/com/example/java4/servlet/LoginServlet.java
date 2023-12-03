package com.example.java4.servlet;


import com.example.java4.Singleton.KhachHangSingleton;
import com.example.java4.model.KhachHang;
import com.example.java4.model.SanPham;
import com.example.java4.service.KhachHangService;
import com.example.java4.service.SanPhamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet( value={"/login","/enter","/return"})
public class LoginServlet extends HttpServlet {
    ArrayList<KhachHang> lstKhachHangs = new ArrayList<>();
    ArrayList<SanPham> lstSanPhams = new ArrayList<>();
    KhachHangService khachHangService = new KhachHangService();
    SanPhamService sanPhamService = new SanPhamService();
    String idHookup = null;
    public void reload(){
        lstKhachHangs = khachHangService.getAll();
    }
    public void reloadSanPham(){
           lstSanPhams = sanPhamService.getAllSP();
    }
    public boolean checkingPort(String userName,String pass){
        reload();
        boolean stt = false;
        for (KhachHang kh : lstKhachHangs) {
             if(kh.getSdt().equals(userName)&&kh.getMatKhau().equals(pass)){
                 idHookup = kh.getIdKhachHang();
                 stt = true;
                 KhachHangSingleton.getInstance().khachHang = kh;
                 break;
             }
             else{
                 stt = false;
             }
        }
        return stt;
    }
    public void init(){
        System.out.println("init success");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do get!");
        String uri = request.getRequestURI();
        if(uri.contains("/login")){
            request.getRequestDispatcher("views/Login.jsp").forward(request,response);
        }
        if(uri.contains("/enter")){
             String userName = request.getParameter("userNameInp");
             String pass = request.getParameter("passInp");
             if(checkingPort(userName,pass)==true){
                 KhachHang khachHang = KhachHangSingleton.getInstance().khachHang;
                 reloadSanPham();
                 request.setAttribute("khachHang",khachHang);
                 request.setAttribute("lstSanPham",lstSanPhams);
                 request.getRequestDispatcher("views/Shoping.jsp").forward(request,response);
             }
        }
        if(uri.contains("/return")){
             response.sendRedirect("/Home");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do post!");
    }
    public void destroy() {
        System.out.println("do destroy!");
    }
}
