package by.grodno.pvt.site.webappsample.service;

public class SQL {

    //    public static final String SELECT_ALL = "select * from public.testtable order by id";
    public static final String SELECT_ALL = "select *  from testtable a left join  dept b on a.dept_num = b.id order by a.id";
    public static final String SELECT_ALL_Dep = "select *  from dept  order by id";
    public static final String DELETE_BY_ID = "delete from public.testtable where id = ?";
    public static final String INSERT = "INSERT INTO public.testTable "
            + "(empl_name, empl_last_name, salary, birthdate,  male, dept_num) VALUES (?,?,?,?,?,?)";
    //            + " Insert into dept (id ,dept_name) values (?,?)";
    public static final String EDIT_ALL = "UPDATE public.testTable SET " +
            "empl_name = ? , empl_last_name = ? , salary = ? ," +
            " birthdate = ? , male = ? , dept_num = ? " + " WHERE id = ?";
    public static final String SELECT_ALL_DEPTNUM = "select *  from testtable a right join  dept b on a.dept_num = b.id  where b.id = ?";
}
//SElect * from testtable
//        select * from dept
//        CREATE TABLE public.dept
//
//        select *  from testtable a left join  dept b on a.dept_num = b.id order by a.id
//
//        select *  from testtable a
//        left join  dept b
//        on a.dept_num = b.id
//        order by a.id
//        (
//        id serial PRIMARY KEY NOT NULL,
//        dept_name character varying(255)
//        );
//        ALTER TABLE public.testTable
//        ADD FOREIGN KEY (dept_num) REFERENCES public.dept(id);
//        ALTER TABLE public.testTable ADD COLUMN dept_num integer;
//
//        INSERT INTO public.dept (dept_name)
//        VALUES ('master')
//
//
//        UPDATE public.testTable
//        SET dept_num = 2
//        WHERE id = 2;
//
//        SELECT AVG(dept_num) FROM public.testtable;
//
//        sELECT COUNT(*) as "Employe count", d.dept_name as "Department name"
//        FROM public.testtable t
//        JOIN public.dept d ON t.dept_num = d.id
//        GROUP BY d.dept_name
//        HAVING d.dept_name = 'Tech';
