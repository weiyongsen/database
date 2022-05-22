import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GaussDBopenGaussDemo{

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://120.46.185.95:8000/finance";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "db_user15";
    static final String PASS = "db_user@15";
    static Connection conn = null;  // 定义为全局变量
    static Statement stmt = null;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 实例化对象
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            System.out.println(" 进入系统... ");
            // 初始化输入

            int flag = 1; //标志循环是否还在进行
            while(flag==1){
                System.out.println("选择子界面(数字): \n" +
                        " 1.添加功能菜单 \n" +
                        " 2.删除功能菜单 \n" +
                        " 3.查询功能菜单 \n" +
                        " 4.修改功能菜单 \n" +
                        "99.退出系统" );
                System.out.print("输入需要跳转的子界面:");


                int input = scan.nextInt();
                switch (input){
                    case 1:
                        Create();
                        break;
                    case 2:
                        Delete();
                        break;
                    case 3:
                        Retrive();
                        break;
                    case 4:
                        Update();
                        break;
                    case 99:
                        flag = 0;
                        break;
                    default:
                        System.out.println("不存在此子功能界面! \n");
                        break;
                }
            }
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
    // 查看子菜单
    public static void Retrive(){
        int flag = 1; //标志循环是否还在进行
        while(flag==1){
            System.out.println("选择功能: \n" +
                    " 1.查看部门表 \n" +
                    " 2.查看项目表 \n" +
                    " 3.查看员工基本信息 \n" +
                    " 4.查看员工的部门分配情况 \n" +
                    " 5.查看员工的项目分配情况 \n" +
                    " 6.查看员工的部门及项目信息 \n" +
                    " 7.查看员工工作调动 \n" +
                    " 8.查看员工工资表 \n" +
                    " 9.根据部门名称查id \n" +
                    "10.根据项目名称查id \n" +
                    "11.根据员工名称查id \n" +
                    "99.退出查询菜单" );
            System.out.print("请选择需要的功能(输入数字):");
            int input = scan.nextInt();
            switch (input){
                case 1:
                    department_retrive();
                    break;
                case 2:
                    project_retrive();
                    break;
                case 3:
                    employee_basicinfo_retrive();
                    break;
                case 4:
                    employee_deparment_retrive();
                    break;
                case 5:
                    employee_project_retrive();
                    break;
                case 6:
                    employee_jobinfo_retrive();
                    break;
                case 7:
                    jobmove_retrive();
                    break;
                case 8:
                    salary_retrive();
                    break;
                case 9:
                    department_id();
                    break;
                case 10:
                    project_id();
                    break;
                case 11:
                    employee_id();
                    break;
                case 99:
                    flag = 0;
                    System.out.println("已退出查询菜单。\n");
                    break;
                default:
                    System.out.println("不存在此功能! \n");
                    break;
            }
        }
    }
    // 添加子菜单
    public static void Create(){
        int flag = 1; //标志循环是否还在进行
        while(flag==1){
            System.out.println("选择功能: \n" +
                    " 1.添加部门 \n" +
                    " 2.添加项目 \n" +
                    " 3.添加员工 \n" +
                    " 4.添加开支信息 \n" +
                    " 5.向某部门添加员工 \n" +
                    " 6.向某项目添加员工 \n" +
                    "99.退出添加菜单" );
            System.out.print("请选择需要的功能(输入数字):");
            int input = scan.nextInt();
            switch (input){
                case 1:
                    department_add();
                    break;
                case 2:
                    project_add();
                    break;
                case 3:
                    employee_add();
                    break;
                case 4:
                    salary_add();
                    break;
                case 5:
                    department_add_employee();
                    break;
                case 6:
                    project_add_employee();
                    break;
                case 99:
                    flag = 0;
                    System.out.println("已退出添加菜单。\n");
                    break;
                default:
                    System.out.println("不存在此功能! \n");
                    break;
            }
        }
    }
    // 删除子菜单
    public static void Delete(){
        int flag = 1; //标志循环是否还在进行
        while(flag==1){
            System.out.println("选择功能: \n" +
                    " 1.删除部门 \n" +
                    " 2.删除项目 \n" +
                    " 3.删除员工 \n" +
                    " 4.从某部门删除某员工 \n" +
                    " 5.从某项目删除某员工 \n" +
                    "99.退出删除菜单" );
            System.out.print("请选择需要的功能(输入数字):");
            int input = scan.nextInt();
            switch (input){
                case 1:
                    department_delete();
                    break;
                case 2:
                    project_delete();
                    break;
                case 3:
                    employee_delete();
                    break;
                case 4:
                    department_del_employee();
                    break;
                case 5:
                    project_del_employee();
                    break;
                case 99:
                    flag = 0;
                    System.out.println("已退出删除菜单。\n");
                    break;
                default:
                    System.out.println("不存在此功能! \n");
                    break;
            }
        }
    }
    // 修改子菜单
    public static void Update(){
        int flag = 1; //标志循环是否还在进行
        while(flag==1){
            System.out.println("选择功能: \n" +
                    " 1.员工基本信息修改 \n" +
                    " 2.员工部门调动 \n" +
                    " 3.员工职务调动 \n" +
                    "99.退出修改菜单" );
            System.out.print("请选择需要的功能(输入数字):");
            int input = scan.nextInt();
            switch (input){
                case 1:
                    employee_info_update();
                    break;
                case 2:
                    department_update();
                    break;
                case 3:
                    job_update();
                    break;
                case 99:
                    flag = 0;
                    System.out.println("已退出修改菜单。\n");
                    break;
                default:
                    System.out.println("不存在此功能! \n");
                    break;
            }
        }
    }

    // 查找部门列表
    public static void department_retrive(){
        // 执行查询
        String sql;
        sql = "SELECT * FROM department order by id";
        try {
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("id");
                String name = rs.getString("name");

                // 输出数据
                System.out.print("部门编号: " + id);
                System.out.print(", 部门名称: " + name);
                System.out.print("\n");
            }
            System.out.println();
            rs.close();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 查找项目列表
    public static void project_retrive(){
        // 执行查询
        String sql;
        sql = "SELECT * FROM project order by id";
        try {
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("id");
                String name = rs.getString("name");

                // 输出数据
                System.out.print("项目编号: " + id);
                System.out.print(", 项目名称: " + name);
                System.out.print("\n");
            }
            System.out.println();
            rs.close();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 查找当前员工基本信息
    public static void employee_basicinfo_retrive(){
        // 执行查询
        String sql;
        sql = "SELECT * FROM employee order by id";
        try {
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("id");
                int did = rs.getInt("did");
                int gender = rs.getInt("gender");
                int age = rs.getInt("age");
                String name = rs.getString("name");
                String job = rs.getString("job");

                String g = gender==1 ? "男":"女";
                // 输出数据
                System.out.print("工号: " + id);
                System.out.print(", 姓名: " + name);
                System.out.print(", 性别: " + g);
                System.out.print(", 年龄: " + age);
                System.out.print(", 工作: " + job);
                System.out.print("\n");
            }
            System.out.println();
            rs.close();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 查询员工的部门信息
    public static void employee_deparment_retrive(){
        // 执行查询
        String sql, sql2;
        sql = "SELECT e.id,e.name,d.name FROM employee as e,department as d where e.did = d.id order by e.id";
        sql2 = "select id from employee";
        try {
            ResultSet rs = stmt.executeQuery(sql);

            ArrayList<Integer> usr_working = new ArrayList<Integer>();    // 目前有部门的员工
            ArrayList<Integer> usr_all = new ArrayList<Integer>();    // 目前有部门的员工
            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int eid = rs.getInt(1);
                String name1 = rs.getString(2);
                String name2 = rs.getString(3);
                usr_working.add(eid);
                // 输出数据
                System.out.print("员工工号: " + eid);
                System.out.print(", 员工姓名: " + name1);
                System.out.print(", 部门名称: " + name2);
                System.out.print("\n");
            }
            rs.close();
            ResultSet rs2 = stmt.executeQuery(sql2);
            while (rs2.next()) {
                // 通过字段检索
                int id = rs2.getInt("id");
                usr_all.add(id);
            }
            rs2.close();
            // 求差集
            boolean ret = usr_all.removeAll(usr_working);
            Iterator<Integer> it = usr_all.iterator();
            System.out.print("未分配部门的员工工号:");
            if(usr_all.size()==0)
                System.out.print(" 无");
            else
                while(it.hasNext()){
                    System.out.print(it.next()+"  ");
                }
            System.out.println("\n");
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 查询员工的项目信息
    public static void employee_project_retrive(){
        // 执行查询
        String sql, sql2;
        sql = "SELECT e.id,e.name,p.name FROM employee as e,project as p, ep " +
                "where (ep.eid=e.id and ep.pid=p.id) order by e.id";
        sql2 = "select id from employee";
        try {
            ResultSet rs = stmt.executeQuery(sql);

            ArrayList<Integer> usr_working = new ArrayList<Integer>();    // 目前有项目的员工
            ArrayList<Integer> usr_all = new ArrayList<Integer>();    // 目前有项目的员工
            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int eid = rs.getInt(1);
                String name1 = rs.getString(2);
                String name2 = rs.getString(3);
                usr_working.add(eid);
                // 输出数据
                System.out.print("员工工号: " + eid);
                System.out.print(", 员工姓名: " + name1);
                System.out.print(", 项目名称: " + name2);
                System.out.print("\n");
            }
            rs.close();
            ResultSet rs2 = stmt.executeQuery(sql2);
            while (rs2.next()) {
                // 通过字段检索
                int id = rs2.getInt("id");
                usr_all.add(id);
            }
            rs2.close();
            // 求差集
            boolean ret = usr_all.removeAll(usr_working);
            Iterator<Integer> it = usr_all.iterator();
            System.out.print("未分配项目的员工工号:");
            if(usr_all.size()==0)
                System.out.print(" 无");
            else
                while(it.hasNext()){
                    System.out.print(it.next()+"  ");
                }
            System.out.println("\n");
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 查找当前员工工作信息
    public static void employee_jobinfo_retrive(){
        // 执行查询
        String sql, sql2;
        sql = "SELECT e.id,e.name,d.name,p.name FROM employee as e,department as d,project as p, ep " +
                "where (e.did = d.id) and (ep.eid=e.id and ep.pid=p.id)";
        sql2 = "select id from employee";
        try {
            ResultSet rs = stmt.executeQuery(sql);

            ArrayList<Integer> usr_working = new ArrayList<Integer>();    // 目前有部门和项目的员工
            ArrayList<Integer> usr_all = new ArrayList<Integer>();    // 目前有部门和项目的员工
            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int eid = rs.getInt(1);
                String name1 = rs.getString(2);
                String name2 = rs.getString(3);
                String name3 = rs.getString(4);
                usr_working.add(eid);
                // 输出数据
                System.out.print("员工工号: " + eid);
                System.out.print(", 员工姓名: " + name1);
                System.out.print(", 部门名称: " + name2);
                System.out.print(", 项目名称: " + name3);
                System.out.print("\n");
            }
            rs.close();
            ResultSet rs2 = stmt.executeQuery(sql2);
            while (rs2.next()) {
                // 通过字段检索
                int id = rs2.getInt("id");
                usr_all.add(id);
            }
            rs2.close();
            // 求差集
            boolean ret = usr_all.removeAll(usr_working);
            Iterator<Integer> it = usr_all.iterator();
            System.out.print("未进行工作人员工号:");
            if(usr_all.size()==0)
                System.out.print(" 无");
            else
                while(it.hasNext()){
                    System.out.print(it.next()+"  ");
                }

            System.out.println("\n");
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 查找当前员工薪水信息
    public static void salary_retrive(){
        // 执行查询
        String sql;
        sql = "SELECT s.id,e.name,s.salary,s.rewards,s.time FROM salary as s, employee as e where s.eid = e.id";
        try {
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("id");
                String ename = rs.getString("name");
                float salary = rs.getFloat("salary");
                float rewards = rs.getInt("rewards");
                String time = rs.getString("time");

                // 输出数据
                System.out.print("开支编号: " + id);
                System.out.print(", 姓名: " + ename);
                System.out.print(", 薪水: " + salary);
                System.out.print(", 奖金: " + rewards);
                System.out.print(", 时间: " + time);
                System.out.print("\n");
            }
            System.out.println();
            rs.close();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 查找员工工作调动信息
    public static void jobmove_retrive(){
        // 执行查询
        String sql;
        sql = "SELECT j.id,e.name,j.department,j.job,j.time FROM jobmove as j,employee as e where j.eid = e.id";
        try {
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String d = rs.getString("department");
                String j = rs.getString("job");
                String t = rs.getString("time");

                // 输出数据
                System.out.print("调动编号: " + id);
                System.out.print(", 姓名: " + name);
                System.out.print(", 调往部门: " + d);
                System.out.print(", 调往职位: " + j);
                System.out.print(", 调动时间: " + t);
                System.out.print("\n");
            }
            System.out.println();
            rs.close();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 根据名称查部门id
    public static void department_id(){
        System.out.print("输入部门名称: ");
        String name = scan.next();
        // 执行查询
        String sql;
        sql = String.format("select id from department where name='%s'",name);
        try {
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Integer> ans = new ArrayList<Integer>();
            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("id");
                ans.add(id);
            }
            int num = ans.size();
            if(num==0){
                System.err.println("不存在该部门!");
            }else{
                System.out.println(ans);
            }
            System.out.println();
            rs.close();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 根据名称查项目id
    public static void project_id(){
        System.out.print("输入项目名称: ");
        String name = scan.next();
        // 执行查询
        String sql;
        sql = String.format("select id from project where name='%s'",name);
        try {
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Integer> ans = new ArrayList<Integer>();
            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("id");
                ans.add(id);
            }
            int num = ans.size();
            if(num==0){
                System.err.println("不存在该项目!");
            }else{
                System.out.println(ans);
            }
            System.out.println();
            rs.close();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 根据名称查部门id
    public static void employee_id(){
        System.out.print("输入员工名称: ");
        String name = scan.next();
        // 执行查询
        String sql;
        sql = String.format("select id from employee where name='%s'",name);
        try {
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Integer> ans = new ArrayList<>();
            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("id");
                ans.add(id);
            }
            int num = ans.size();
            if(num==0){
                System.err.println("不存在该员工!");
            }else{
                System.out.println(ans);
            }
            System.out.println();
            rs.close();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }

    // 添加部门
    public static void department_add(){
        // 读名字
        System.out.print("输入要添加的部门名称: ");
        String name = scan.next();
        String sql = "select max(id) from department";
        try {
            // 获取id值
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int pos = rs.getInt(1)+1;
            rs.close();
            // 执行添加
            sql = String.format("insert into department values (%d,'%s')",pos,name);
            stmt.executeUpdate(sql);
            System.out.println("添加部门成功!\n");
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 添加项目
    public static void project_add(){
        // 名字
        System.out.print("输入要添加的项目名称: ");
        String name = scan.next();
        // sql
        String sql = "select max(id) from project";
        try {
            // 获取id值
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int pos = rs.getInt(1)+1;
            rs.close();
            // 执行添加
            sql = String.format("insert into project values(%d,'%s')",pos,name);
            stmt.executeUpdate(sql);
            System.out.println("添加项目成功!\n");
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 添加员工
    public static void employee_add(){
        // 名字
        System.out.println("按提示输入要添加的员工信息");
//        System.out.print("部门编号: ");
        int dp_id =  -1;  // 默认没有编号
        System.out.print("员工姓名: ");
        String name = scan.next();
        System.out.print("员工性别(01): ");
        int gender =  scan.nextInt();
        System.out.print("员工年龄: ");
        int age =  scan.nextInt();
        System.out.print("员工职务: ");
        String job = scan.next();
        // sql
        String sql = "select max(id) from employee";
        try {
            // 获取id值
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int pos = rs.getInt(1)+1;
            rs.close();
            System.out.println(pos);
            // 执行添加
            sql = String.format("insert into employee values(%d,%d,%d,%d,'%s','%s')",pos,dp_id,gender,age,name,job);
            System.out.println(sql);
            stmt.executeUpdate(sql);
            System.out.println("添加员工成功!\n");
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 添加开支记录
    public static void salary_add(){
        // 名字
        System.out.println("按提示输入信息");
        System.out.print("员工工号: ");
        int eid =  scan.nextInt();
        System.out.print("基本工资: ");
        float salary =  scan.nextFloat();
        System.out.print("奖金: ");
        float rewards =  scan.nextFloat();
        // sql
        String sql = "select max(id) from salary";
        try {
            // 获取id值
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int pos = rs.getInt(1)+1;
            rs.close();
            // 执行添加
            sql = String.format("insert into salary (id,eid,salary,rewards)" +
                    " values(%d,%d,%f,%f)",pos,eid,salary,rewards);
            stmt.executeUpdate(sql);
            System.out.println("添加开支信息成功!\n");
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 向某部门添加员工
    public static void department_add_employee(){
        // 名字
        System.out.println("按提示输入信息");
        System.out.print("员工工号: ");
        int eid =  scan.nextInt();
        System.out.print("部门编号: ");
        int did =  scan.nextInt();
        // sql
        String sql = String.format("update employee set did=%d where id=%d",did,eid);
        try {
            stmt.executeUpdate(sql);
            System.out.println("成功添加员工到部门!\n");
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 向某项目添加员工
    public static void project_add_employee(){
        // 名字
        System.out.println("按提示输入信息");
        System.out.print("员工工号: ");
        int eid =  scan.nextInt();
        System.out.print("项目编号: ");
        int pid =  scan.nextInt();
        // sql
        String sql = String.format("insert into ep values(%d,%d)",eid,pid);
        try {
            stmt.executeUpdate(sql);
            System.out.println("成功添加员工到项目!\n");
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }

    // 删除部门
    public static void department_delete(){
        // 编号
        System.out.print("输入要删除的部门编号: ");
        int id =  scan.nextInt();
        // sql
        String sql = String.format("delete from department where id = %d",id);
        // 将employee中该部门的员工did置-1
        String sql2 = String.format("update employee set did = -1 where did = %d",id);
        try {
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            System.out.println("成功删除该部门!\n");
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 删除项目
    public static void project_delete(){
        // 编号
        System.out.print("输入要删除的项目编号: ");
        int id =  scan.nextInt();
        // sql
        String sql = String.format("delete from project where id = %d",id); //从项目表中删除
        String sql2 = String.format("delete from ep where pid = %d",id);    // 从ep表中删除
        try {
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            System.out.println("成功删除该项目!\n");
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 删除员工
    public static void employee_delete(){
        // 编号
        System.out.print("输入要删除的员工编号: ");
        int id =  scan.nextInt();
        // sql
        String sql = String.format("delete from employee where id = %d",id); //从员工表中删除
        String sql2 = String.format("delete from ep where eid = %d",id); //从员工-项目联系表中删除
        String sql3 = String.format("delete from jobmove where eid = %d",id); //从工作调动表中删除
        try {
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
            System.out.println("成功删除该员工!\n");
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 从项目中删除员工
    public static void project_del_employee(){
        // 编号
        System.out.print("输入项目编号: ");
        int pid =  scan.nextInt();
        System.out.print("输入员工编号: ");
        int eid =  scan.nextInt();
        // sql
        String sql = String.format("delete from ep where eid = %d and pid=%d",eid,pid); //从员工表中删除
        try {
            stmt.executeUpdate(sql);
            System.out.println("成功从部门中删除该员工!\n");
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 从部门中删除员工
    public static void department_del_employee(){
        // 编号
        System.out.print("输入部门编号: ");
        int did =  scan.nextInt();
        System.out.print("输入员工编号: ");
        int eid =  scan.nextInt();
        // sql
        String sql = String.format("update employee set did=-1 where id = %d and did=%d",eid,did); //从员工表中删除
        try {
            stmt.executeUpdate(sql);
            System.out.println("成功从部门中删除该员工!\n");
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }

    // 更新员工基本信息
    public static void employee_info_update(){
        // 读名字
        System.out.print("输入要调动的员工编号: ");
        int id = scan.nextInt();
        System.out.print("输入要调动的员工性别: ");
        int gender = scan.nextInt();
        System.out.print("输入要调动的员工年龄: ");
        int age = scan.nextInt();
        System.out.print("输入要更改为的名字: ");
        String name = scan.next();
        String sql = String.format("update employee set gender=%d, age=%d, name='%s' where id=%d",gender,age,name,id);
        try {
            stmt.executeUpdate(sql);
            System.out.println("修改员工基本信息成功!\n");
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 部门调动
    public static void department_update(){
        // 读名字
        System.out.print("输入要调动的员工编号: ");
        int eid = scan.nextInt();
        System.out.print("输入要调往的部门编号: ");
        int did = scan.nextInt();
        String sql = "select max(id) from jobmove";
        try {
            // 获取id值
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int pos = rs.getInt(1)+1;

            // 查找dname
            sql = String.format("select name from department where id=%d",did);
            rs = stmt.executeQuery(sql);
            rs.next();
            String dname = rs.getString(1);
            rs.close();
            if(dname.length()>0){
                // 执行jobmove添加
                sql = String.format("insert into jobmove values (%d,%d,'%s','%s')",pos,eid,dname,null);
                stmt.executeUpdate(sql);
                // 执行employee修改
                sql = String.format("update employee set did=%d where id=%d",did,eid);
                stmt.executeUpdate(sql);
                System.out.println("修改部门成功!\n");
            }else{
                System.out.println("修改失败!\n");
            }

        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    // 职务调动
    public static void job_update(){
        // 读名字
        System.out.print("输入要调动的员工编号: ");
        int eid = scan.nextInt();
        System.out.print("输入要调往的职务名称: ");
        String jobname = scan.next();
        String sql = "select max(id) from jobmove";
        try {
            // 获取id值
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int pos = rs.getInt(1)+1;
            rs.close();

            if(jobname.length()>0){
                // 执行jobmove添加
                sql = String.format("insert into jobmove values (%d,%d,'%s','%s')",pos,eid,null,jobname);
                stmt.executeUpdate(sql);
                // 执行employee修改
                sql = String.format("update employee set job='%s' where id=%d",jobname,eid);
                stmt.executeUpdate(sql);
                System.out.println("修改职务成功!\n");
            }else{
                System.out.println("修改失败!\n");
            }

        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }


}
