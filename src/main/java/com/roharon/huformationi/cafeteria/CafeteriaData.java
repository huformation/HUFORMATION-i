package com.roharon.huformationi.cafeteria;

public interface CafeteriaData {

    String InmoonUrl = "https://wis.hufs.ac.kr/jsp/HUFS/cafeteria/viewWeek.jsp?startDt="
            + "%s&endDt=" + "%s&caf_name=인문관식당&caf_id=h101";

    String GyosooUrl = "https://wis.hufs.ac.kr/jsp/HUFS/cafeteria/viewWeek.jsp?startDt="
            + "%s&endDt=" + "%s&caf_name=교수회관식당&caf_id=h102";

    String SkyloungeUrl = "https://wis.hufs.ac.kr/jsp/HUFS/cafeteria/viewWeek.jsp?startDt="
            + "%s&endDt=" + "%s&caf_name=스카이라운지&caf_id=h103";

    String GookjeUrl = "https://wis.hufs.ac.kr/jsp/HUFS/cafeteria/viewWeek.jsp?startDt="
            + "%s&endDt=" + "%s&caf_name=국제사회교육원식당&caf_id=h201";

    String HoosengGyojikUrl = "https://wis.hufs.ac.kr/jsp/HUFS/cafeteria/viewWeek.jsp?startDt="
            + "%s&endDt=" + "%s&caf_name=후생관+교직원식당&caf_id=h202";

    String HoosengStudentUrl = "https://wis.hufs.ac.kr/jsp/HUFS/cafeteria/viewWeek.jsp?startDt="
            + "%s&endDt=" + "%s&caf_name=후생관+학생식당&caf_id=h203";

    String UmoonUrl = "https://wis.hufs.ac.kr/jsp/HUFS/cafeteria/viewWeek.jsp?startDt="
            + "%s&endDt=" + "%s&caf_name=어문관&caf_id=h204";

    String HufsdormUrl = "https://wis.hufs.ac.kr/jsp/HUFS/cafeteria/viewWeek.jsp?startDt="
            + "%s&endDt=" + "%s&caf_name=HufsDorm+식당&caf_id=h205";

    enum Cafe{
        INMOON, GYOSOO, SKYLOUNGE, GOOKJE, HOOSENG_GYOJIK, HOOSENG_STUDENT, UMOON, HUFSDORM
    }

}
