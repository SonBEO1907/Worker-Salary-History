package Database;

import java.util.ArrayList;
import java.util.List;
import s56.SalaryHistory;
import s56.Worker;

/**
 *
 * @author son75
 */
public interface WorkerData {
    List<Worker> workerList = new ArrayList<>();
    List<SalaryHistory> salaryHistoryList = new ArrayList<>();
}
