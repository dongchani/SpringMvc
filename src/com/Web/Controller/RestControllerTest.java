package com.Web.Controller;

import com.Web.format.TestFormat;
import com.commons.entity.Life;
import com.commons.entity.Ponit;
import com.commons.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class RestControllerTest {

    @RequestMapping("/tologin")
    public String  login(){
        return  "login";
    }

    /**
     * 源码：HttpMessageConverter<T>
     *HttpResponse 认识吗？  不认识！
     * 所以需要借助HttpMessageConverter=》User=》合适的类型进行响应=》writeInternal进行将对象合适的转换成合适的类型
     *
     * @return
     */
    @RequestMapping("/User")
    public void user(User user){

        System.out.println(user);
        System.out.println(user.getPonit().getX());
    }


    /**
     *
     * @PathVariable路径变量的值会赋给方法中形参的值
     * @param id
     * @return
     */
    @GetMapping("/id/{id}")
    public String pathVaribale(@PathVariable("id") Integer id){
        return id.toString();
    }

    /**
     * 只接受JSON类型的数据   其他的都不接收
     * @RequestBody 参数的对象应绑定到Web请求的主体。（json的形式要和参数的数据一一对应）
     *拿到@RequestBody的请求体 通过 getInputStream 拿到
     * @consumes 接收用户的媒体类型
     * @produces 响应用户的媒体类型
     * @return
     */
/*     @RequestMapping(name = "/Life" ,consumes = "application/json")
    public Life life(@RequestBody Life life,HttpServletRequest request)throws IOException {
        request.getInputStream();
        return  life;
    }*/



    /**
     *
     * @RequestParam将请求参数赋给方法中的形参
     *
     *
     * @return
     */
    @GetMapping("/Users")
    public String user1(@RequestParam("uid") Integer id){
        System.out.println(id);
        return "login";
    }


    /**
     * 解析顺序：优先使用model中存在的值（model=》user）
     * 数据绑定，它使您不必处理解析和转换单个查询参数和表单字段
     * 方法参数或方法返回值绑定到命名模型属性的注释，公开给Web视图。
     * 作用在参数上
     * @RequestParam("id")
     * @param id
     * @param model
     * @return
     */
   @RequestMapping("/model")
     public  String tologinPageByModel(@ModelAttribute(name ="uid") String id,Model model){
       System.out.println(model);
        return  id.toString();
     }
    /**
     * 作用在方法上
     */
    @ModelAttribute (name="user")
    public User user2(){
        User user = new User();
        user.setUserName("admin");
        user.setUserPassword("123");
        return user;
    }

    @RequestMapping("/ResponseEntity")

    public ResponseEntity<User> user(){
        User user = new User();
        user.setUserName("111");
        user.setUserPassword("123456");
        ResponseEntity responseEntity = new ResponseEntity(user, HttpStatus.OK);
        return responseEntity;
    }
    /**
     * 404页面上会出现逻辑视图名
     * 并且ModelAndView ：HandlerAdapter也是
     * requestParm
     */
    @RequestMapping("/loginvoid")
    public void login(User user) {
        System.out.println(user);
    }

    /**
     * 将请求参数（即表单或查询数据）绑定到模型对象
     * 将基于字符串的请求值（例如请求参数，路径变量，标题，cookie等）绑定到对应的入参对象上
     *
     * 解释为什么我们可以直接在方法参数里用User
     * @param webDataBinder
     */
    @InitBinder
    public void Initbinder(WebDataBinder webDataBinder){
        webDataBinder.addCustomFormatter(new TestFormat(),Ponit.class);
    }
}
