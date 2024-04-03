package org.czareg.codewars.the.latest.clock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClockTest {

    private static final String TEST_TITLE = "latestClock({0}, {1}, {2}, {3}) should return \"{4}\"";

    @Order(1)
    @ParameterizedTest(name = TEST_TITLE)
    @DisplayName("Fixed tests")
    @MethodSource("fixedTestsProvider")
    void fixedTests(int a, int b, int c, int d, String expected) {
        assertEquals(expected, Clock.latestClock(a, b, c, d));
    }

    @Order(2)
    @ParameterizedTest(name = TEST_TITLE)
    @DisplayName("Random tests")
    @MethodSource("randomTestsProvider")
    void randomTests(int a, int b, int c, int d, String expected) {
        assertEquals(expected, Clock.latestClock(a, b, c, d));
    }

    public static Stream<Arguments> fixedTestsProvider() {
        return Stream.of(
                Arguments.of(9, 1, 2, 5, "21:59"),
                Arguments.of(1, 9, 8, 3, "19:38"),
                Arguments.of(1, 2, 8, 9, "19:28"),
                Arguments.of(0, 0, 0, 0, "00:00"),
                Arguments.of(2, 4, 0, 0, "20:40")
        );
    }

    public static Stream<Arguments> randomTestsProvider() {
        var allValidResults = new ArrayList<>(List.of(
                // all valid "latest" 24-h clocks, encoded as minutes since midnight
                0, 180, 210, 213, 240, 270, 273, 280, 283, 284, 300, 330, 333, 340, 343, 344, 350, 353, 354, 355, 360, 366, 386, 390, 393, 396, 400, 403, 404, 406, 410, 413,
                414, 415, 416, 420, 426, 427, 446, 447, 450, 453, 456, 457, 460, 463, 464, 466, 467, 470, 473, 474, 475, 476, 477, 480, 486, 487, 488, 506, 507, 508, 510, 513,
                516, 517, 518, 520, 523, 524, 526, 527, 528, 530, 533, 534, 535, 536, 537, 538, 540, 546, 547, 548, 549, 566, 567, 568, 569, 570, 573, 576, 577, 578, 579, 580,
                583, 584, 586, 587, 588, 589, 590, 593, 594, 595, 596, 597, 598, 599, 600, 660, 670, 671, 780, 790, 791, 810, 811, 813, 840, 850, 851, 870, 871, 873, 880, 881,
                883, 884, 900, 910, 911, 930, 931, 933, 940, 941, 943, 944, 950, 951, 953, 954, 955, 960, 966, 970, 971, 976, 986, 990, 991, 993, 996, 1000, 1001, 1003, 1004,
                1006, 1010, 1011, 1013, 1014, 1015, 1016, 1020, 1026, 1027, 1030, 1031, 1036, 1037, 1046, 1047, 1050, 1051, 1053, 1056, 1057, 1060, 1061, 1063, 1064, 1066, 1067,
                1070, 1071, 1073, 1074, 1075, 1076, 1077, 1080, 1086, 1087, 1088, 1090, 1091, 1096, 1097, 1098, 1106, 1107, 1108, 1110, 1111, 1113, 1116, 1117, 1118, 1120, 1121,
                1123, 1124, 1126, 1127, 1128, 1130, 1131, 1133, 1134, 1135, 1136, 1137, 1138, 1140, 1146, 1147, 1148, 1149, 1150, 1151, 1156, 1157, 1158, 1159, 1166, 1167, 1168,
                1169, 1170, 1171, 1173, 1176, 1177, 1178, 1179, 1180, 1181, 1183, 1184, 1186, 1187, 1188, 1189, 1190, 1191, 1193, 1194, 1195, 1196, 1197, 1198, 1199, 1200, 1206,
                1207, 1208, 1209, 1240, 1244, 1246, 1247, 1248, 1249, 1250, 1254, 1255, 1256, 1257, 1258, 1259, 1260, 1266, 1267, 1268, 1269, 1270, 1271, 1276, 1277, 1278, 1279,
                1300, 1301, 1304, 1306, 1307, 1308, 1309, 1310, 1311, 1314, 1315, 1316, 1317, 1318, 1319, 1320, 1326, 1327, 1328, 1329, 1330, 1331, 1336, 1337, 1338, 1339, 1340,
                1341, 1342, 1346, 1347, 1348, 1349, 1360, 1361, 1362, 1364, 1366, 1367, 1368, 1369, 1370, 1371, 1372, 1374, 1375, 1376, 1377, 1378, 1379, 1380, 1386, 1387, 1388,
                1389, 1390, 1391, 1396, 1397, 1398, 1399, 1400, 1401, 1402, 1406, 1407, 1408, 1409, 1410, 1411, 1412, 1413, 1416, 1417, 1418, 1419, 1420, 1421, 1422, 1423, 1424,
                1426, 1427, 1428, 1429, 1430, 1431, 1432, 1433, 1434, 1435, 1436, 1437, 1438, 1439));
        Collections.shuffle(allValidResults);
        return allValidResults
                .stream()
                .map(minutes -> {
                    int a = minutes / 600;
                    int b = minutes / 60 % 10;
                    int c = minutes % 60 / 10;
                    int d = minutes % 10;
                    String expected = String.format("%d%d:%d%d", a, b, c, d);
                    var ds = new ArrayList<>(List.of(a, b, c, d));
                    Collections.shuffle(ds);
                    return Arguments.of(ds.get(0), ds.get(1), ds.get(2), ds.get(3), expected);
                });
    }
}