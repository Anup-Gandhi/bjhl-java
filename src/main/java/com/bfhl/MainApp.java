package com.bfhl;
import com.bfhl.gui.GUI;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;
import java.util.List;
@SpringBootApplication
public class MainApp implements CommandLineRunner {
    @Autowired
    private EntityManager em;
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        List<Object[]> results = em.createNativeQuery("""
            SELECT e1.emp_id, e1.first_name, e1.last_name, d.department_name,
                (SELECT COUNT(*) FROM employee e2 WHERE e2.department = e1.department AND e2.dob > e1.dob) AS younger_count
            FROM employee e1
            JOIN department d ON e1.department = d.department_id
            ORDER BY e1.emp_id DESC
        """).getResultList();
        StringBuilder sb = new StringBuilder("Results:\n");
        for (Object[] row : results) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        GUI.showMessage("SQL Output", sb.toString());
    }
}
