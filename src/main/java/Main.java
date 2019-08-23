import DatabaseQuery.*;
import me.tongfei.progressbar.ProgressBar;

public class Main {
    static {
        System.loadLibrary("DatabaseQueryJava");
    }

    public static void main(String[] args) {
        System.out.println("okay");

        DatabaseQueryManager dqm = new DatabaseQueryManager(
                "/media/yuan/Samsung_T5/patent_data/test/index.tsv",
                "/media/yuan/Samsung_T5/patent_data/test/data");

        StringVector pidList = new StringVector();
        StringVector aidList = new StringVector();

        dqm.getAllId(pidList, aidList);

        System.out.printf("%d %d\n", pidList.size(), aidList.size());
//        for (int i = 0; i < pidList.size(); i++)
//            System.out.println(pidList.get(i));

        StringVector miniPidList = new StringVector(new String[]{pidList.get(0),
                pidList.get(1), pidList.get(2)});

        IdDataRecordVector idDrList = new IdDataRecordVector();
        dqm.getContentByIdList(miniPidList, idDrList);

        for (IdDataRecord idDr : idDrList) {
            System.out.printf("%s %s %s\n", idDr.getPid(), idDr.getAid(),
                    idDr.getDataRecord().getTitle());
        }

        IndexValue indexValue = dqm.getInfoById(pidList.get(0));
        System.out.println(indexValue.stringify());

        ProgressBar pb = new ProgressBar("Getting contents", pidList.size());
        int batch = 1024 * 128;
        int i = 0;
        for (i = batch; i < pidList.size(); i+=batch) {
            IdDataRecordVector idv = new IdDataRecordVector();
            dqm.getContentByIdList(new StringVector(pidList.subList(i-batch, i)), idv);
            pb.stepBy(batch);
        }
        IdDataRecordVector idv = new IdDataRecordVector();
        dqm.getContentByIdList(new StringVector(pidList.subList(i-batch, pidList.size())), idv);
        pb.stepBy(pidList.size() - i + batch);
        pb.close();
    }
}
