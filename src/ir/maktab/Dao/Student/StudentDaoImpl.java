package ir.maktab.Dao.Student;

import ir.maktab.Dao.EntityDao;
import ir.maktab.model.Prof;
import ir.maktab.model.Student;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nader on 11/18/2017.
 */
public class StudentDaoImpl extends EntityDao implements StudentDao {

    {
        TABLE_NAME = "students";
    }

    public static void choose() {
    }

    public boolean add(Student s) throws SQLException {
        if (exist(s))
            return false;

        init();
        String sql;
        if (s.getId() == null)
            sql = String.format("insert into %s (name, dept, supervisor_id)" +
                    " values ('%s', '%s', '%d')", TABLE_NAME, s.getName(), s.getDept(), s.getSupervisor_id());
        else
            sql = String.format("insert into %s " +
                    " values ('%s', '%s', '%s', '%d')", TABLE_NAME, s.getId(), s.getName(), s.getDept(), s.getSupervisor_id());
        stmt.executeUpdate(sql);
        finalize(stmt, conn);

        return true;
    }

    public boolean edit(Student s) throws SQLException {
        if (!exist(s.getId()))
            return false;

        delete(s.getId());
        return add(s);
    }

    public Student get(int id) throws SQLException {
        init();
        String sql = String.format("select * from %s where id='%s'", TABLE_NAME, id);
        rs = stmt.executeQuery(sql);

        Student student = null;
        if (rs.next())
            student = new Student(id, rs.getString("name"), rs.getString("dept"), rs.getInt("supervisor_id"));

        finalize(rs, stmt, conn);
        return student;
    }

    public List<Student> getAll() throws SQLException {

        init();
        String sql;
        sql = "select * from " + TABLE_NAME;
        rs = stmt.executeQuery(sql);

        //STEP 5: Extract data from result set
        List<Student> students = new ArrayList<>();
        while (rs.next()) {
            //Retrieve by column name
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String dept = rs.getString("dept");
            int sid = rs.getInt("supervisor_id");

            students.add(new Student(id, name, dept, sid));
        }
        finalize(rs, stmt, conn);
        return students;
    }

    public DefaultTableModel getAllAsModel() throws SQLException {
        init();
        String sql;
        sql = "select * from " + TABLE_NAME;
        rs = stmt.executeQuery(sql);

        DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Name", "Dept", "prof ID"}, 0);
        boolean flag = false;
        while (rs.next()) {
            //Retrieve by column name
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String dept = rs.getString("dept");
            int sid = rs.getInt("supervisor_id");
            model.addRow(new Object[]{id, name, dept, sid});
            flag = true;
        }
        finalize(rs, stmt, conn);
        if (flag)
            return model;

        return null;
    }

    public DefaultTableModel getAsModel(Student s) throws SQLException {
        init();
        String sql = "select * from " + TABLE_NAME + " where id=" + s.getId();
        rs = stmt.executeQuery(sql);

        DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Name", "Dept", "prof ID"}, 0);
        if (rs.next()) {
            model.addRow(new Object[]{s.getId(), rs.getString("name"), rs.getString("dept"), rs.getString("supervisor_id")});
        }
        finalize(rs, stmt, conn);
        return model;

    }

    public Prof showSupervisor(int id) throws SQLException {
        init();
        Prof prof = null;
        String sql = "select prof.name, address from "
                + "students inner join prof on prof.id=students.supervisor_id "
                + "where students.id = " + id;
        rs = stmt.executeQuery(sql);

        if (rs.next()) {
            String name = rs.getString("name");
            String address = rs.getString("address");

            prof = new Prof(id, name, address);
        }

        finalize(rs, stmt, conn);
        return prof;
    }

    //@Override
    public boolean exist(Student s) throws SQLException {
        if (s.getId() == null)
            return exist(s.getName(), s.getDept());
        else
            return exist(s.getId(), s.getName(), s.getDept());
    }

    private boolean exist(int id, String name, String dept) throws SQLException {
        init();
        try {
            String sql;
            sql = "SELECT * FROM " + TABLE_NAME + " WHERE id ='" + id + "' OR (name='" + name + "' AND dept='" + dept + "')";
            rs = stmt.executeQuery(sql);

            if (rs.next())
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            finalize(rs, stmt, conn);
        }
        return false;
    }

    private boolean exist(String name, String dept) throws SQLException {
        init();
        try {
            String sql;
            sql = "SELECT * FROM " + TABLE_NAME + " WHERE name='" + name + "' AND dept='" + dept + "'";
            rs = stmt.executeQuery(sql);

            if (rs.next())
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            finalize(rs, stmt, conn);
        }
        return false;
    }

}
