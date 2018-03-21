package com.sunlands.rpc.test.api;

import com.sunlands.rpc.api.homepage.handler.ApiHomePageServiceHandler;
import com.sunlands.rpc.api.homepage.service.ApiHomePageService;
import com.sunlands.rpc.api.homepage.service.DailyIntelligentExerciseDTO;
import com.sunlands.rpc.web.statistics.service.WebStatisticsService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * <p>Title:</p>
 * <p>Description:</p>
 *
 * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
 * @date 2018年03月16日
 * @since v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class ApiHomePageServiceTest {

    @Autowired
    protected TProtocolFactory protocolFactory;

    @LocalServerPort
    protected int port;

    protected ApiHomePageService.Client client;

    @Autowired
    private ApiHomePageServiceHandler handler;

    @Before
    public void setUp() throws Exception {
        TTransport transport = new THttpClient("http://localhost:" + port + "/api/homePage");
        TProtocol protocol = protocolFactory.getProtocol(transport);
        client = new ApiHomePageService.Client(protocol);
    }
    @Test
    public void testGroupMember() throws Exception {

//        List<Member> members = client.getGroupMemberListByPerson(0, "wangzhuzhu");
//        Assert.assertEquals(2,members.size());
    }

    @Test
    public void testIsDailyIntelligentExerciseDone() throws TException {
        List<Integer> stuIds = Arrays.asList(3975512,3323699,245408,2199863,2408144,2418527,2632891,3322895,3322896,3322897,3896685,3896688,3896724,3896727,3896728,3896729,3896730,3897077,3979162,2835800,3323096,3979003,3306108,3307481,3308296,3976895,3977239,3977409,3977434,3978439,3978449,3979018,3322903,3896708,3976518,3976532,3976928,3976932,3977407,3977459,3306106,3322230,3323088,3319670,3321491,3306103,3318069,3977622,3977624,3977636,3977704,3306107,3306089,3976480,3976482,3976486,3976487,3976488,3976512,3976529,3976530,3976547,3976562,3976567,3976582,3976585,3976589,3976591,3976601,3976603,3976605,3976606,3976609,3976613,3976624,3976628,3976648,3976670,3976684,3976685,3976687,3976688,3976693,3976694,3976695,3976697,3976700,3976702,3976715,3977388,3977403,3977405,3977412,3977414,3977417,3977418,3977436,3977462,3977485,3977487,3978156,3978158,3978230,3896596,3896682,3897076,3325443,3306022,3306110,3306101,3306111,3306136,3306138,3306261,3306149,3306276,3306152,3319616,3308786,3321540,3324535,3324551,3335038,3306283,3319244,3320818,3324306,3325453,3325456,3325460,3325465,3325468,3325545,3326111,3326114,3308300,3308541,3308552,3308475,3308656,3308659,3308661,3308678,3308684,3308710,3308724,3308729,3319516,3322303,3319669,3320786,3320906,3322266,3322357,3323755,3324240,3327792,3978785,3309192,3976743,3976748,3977411,3977423,3977433,3977439,3309349,3309458,3323494,3896716,3323070,3323071,3323545,3896713,3323097,3323694,3323077,3322922,3325195,3325805,3335870,3335873,3896477,3975574,3311667,3317754,3317929,3318220,3321962,3322018,3322214,3322235,3323728,3318347,3319469,3318603,3318617,3318620,3318822,3319621,3323658,3896362,3896366,3319573,3324692,3319971,3319985,3319990,3320551,3320442,3320489,3320608,3320693,3320639,3320696,3320705,3320740,3320775,3320776,3320777,3320779,3320780,3320782,3320787,3320815,3320821,3320828,3320840,3320838,3320845,3320864,3320959,3323023,3323515,3323652,3325397,3325407,3325409,3977520,3321956,3321964,3323056,3323528,3325231,3322374,3322391,3322503,3322587,3323636,3896578,3896581,3896680,3897074,3893159,3977953,3977954,3321529,3321530,3321557,3321966,3322694,3322341,3322249,3322306,3322348,3322312,3322325,3322324,3322379,3322382,3323060,3323646,3323654,3325235,3977489,3322396,3322537,3322565,3322887,3323104,3322574,3322764,3322882,3322747,3322755,3896508,3322907,3322955,3323025,3323499,3323525,3323687,3323705,3323745,3323773,3323750,3323752,3323761,3896248,3896791,3897107,3323807,3896274,3896349,3896358,3896360,3975637,3323808,3896810,3323809,3896741,3323971,3324000,3324023,3324108,3324303,3324715,3325204,3325257,3325441,3325420,3325591,3977618,3326028,3326742,3326907,3328453,3329264,3329423,3329444,3329450,3329456,3329557,3896371,3896867,3897075,3331701,3331706,3331707,3331710,3331717,3331804,3331833,3331853,3331886,3331906,3331989,3330736,3330739,3897106,3978516,3333787,3896721,3975555,3976510,3334278,3977336,3337301,3893447,3895445,3895446,3895453,3896369,3977839,3896375,3975687,3896381,3975659,3975708,3975711,3975713,3896800,3896812,3896813,3896389,3896387,3896585,3896681,3976598,3976616,3978775,3979037,3896787,3896792,3975861,3975922,3975928,3977958,3978005,3976660,3976662,3976353,3976359,3976361,3976714,3976365,3976366,3976375,3976516,3976521,3976556,3976499,3976568,3976637,3976647,3976650,3976657,3976677,3976680,3976682,3976683,3976691,3976750,3976753,3976757,3977523,3977396,3977482,3977402,3977421,3977435,3977479,3977404,3977410,3977441,3977458,3977465,3977468,3977470,3977475,3977476,3977480,3977534,3977845,3977941,3977961,3978422,3978720,3979147,3978787);
        int size = stuIds.size();
        DateTime before = DateTime.now();
        for (Integer stuId : stuIds) {
            DailyIntelligentExerciseDTO dailyIntelligentExerciseDone = client.isDailyIntelligentExerciseDone(3975512, 3975512);
            System.out.println(dailyIntelligentExerciseDone.done + "|" + dailyIntelligentExerciseDone.hasTiku);
            break;
        }
        DateTime end = DateTime.now();
        printTimeSpend(before, end, size);
    }

    @Test
    public void testGetSubmitQuestionCount() throws TException {
        List<Integer> orderDetailIds = Arrays.asList(27930,346799,659615,705981,705981,705981,705981,705981,705981,705981,705981,705981,705981,705981,705981,705981,705981,705981,705981,707519,1456903,1462291,1480160,1480160,1488841,1518324,1518324,1518324,1518324,1518324,1518324,1518324,1518862,1518862,1518862,1518862,1518862,1518862,1518862,1518862,1522988,1523012,1523506,1523549,1523549,1523595,1523658,1523667,1523667,1523667,1523667,1523725,1573514,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573531,1573532,1573532,1573532,1573539,1573551,1573551,1573580,1573580,1573647,1573648,1573648,1573649,1573649,1573651,1573651,1573669,1573669,1573669,1573669,1573669,1573710,1602509,1602509,1602511,1602511,1602511,1602511,1602511,1602511,1602511,1602511,1602511,1602530,1602546,1602553,1602556,1602601,1602602,1602604,1602606,1602608,1602610,1602611,1602612,1602613,1602613,1602643,1602643,1602643,1602643,1602643,1602643,1602643,1602643,1602643,1602668,1602681,1602681,1602681,1602681,1602681,1602681,1602691,1602710,1602710,1602710,1602738,1602738,1602810,1602810,1602861,1602862,1602863,1602910,1602910,1602910,1602910,1602910,1602910,1602910,1602931,1602999,1603057,1603152,1603163,1603163,1603163,1603163,1603163,1603180,1603186,1603215,1603216,1603219,1603248,1603275,1603319,1603319,1603319,1603334,1603344,1607329,1607333,1607334,1607395,1607479,1607507,1607533,1607542,1607545,1607558,1607562,1607575,1607584,1607586,1607587,1607588,1607589,1607591,1607592,1607619,1607620,1607625,1607627,1607629,1607632,1607645,1607732,1607853,1607853,1607853,1607853,1607853,1607853,1607853,1607855,1607855,1607855,1607855,1607855,1607856,1607856,1607856,1607856,1607856,1607856,1607856,1607856,1607856,1607861,1607861,1607861,1607896,1607896,1607900,1607929,1607929,1607955,1607999,1607999,1607999,1608024,1608024,1608025,1608032,1608032,1608032,1608032,1608034,1608034,1608034,1608036,1608036,1608036,1608036,1608036,1608049,1608049,1608049,1608057,1608059,1608059,1608061,1608062,1608063,1608067,1608068,1608079,1608079,1608079,1608079,1608087,1608087,1608087,1608095,1608095,1608095,1608096,1608096,1608096,1608096,1608096,1608096,1608098,1608098,1608100,1608100,1608128,1608132,1608136,1608152,1608152,1608274,1608308,1608311,1608315,1608318,1608324,1608341,1608362,1608391,1608397,1608575,1608576,1608665,1608666,1608667,1608667,1608671,1608773,1608773,1608773,1608778,1608778,1608778,1608778,1608778,1608778,1608778,1608778,1608778,1608778,1608778,1608796,1608798,1608875,1608903,1608920,1608924,1608924,1608924,1608956,1608970,1609510,1609918,1610030,1610030,1610030,1610047,1610047,1610048,1610048,1610053,1610053,1610053,1610053,1610053,1610092,1610093,1610093,1610096,1610108,1610108,1610108,1611503,1611503,1611503,1611503,1611515,1611515,1611647,1611657,1611681,1611681,1611681,1611746,1611746,1611754,1611754,1611754,1611758,1611777,1611777,1611777,1611817,1611817,1611817,1611829,1611841,1611850,1611850,1611850,1611850,1611856,1611856,1611856,1611856,1611856,1611870,1611870,1611870,1611980,1611992,1611994,1611995,1611995,1611995,1611995,1611996,1611996,1611996,1611998,1611998,1611998,1611998,1611998,1611998,1611998,1612010,1612069,1612127,1612131,1612164,1612164,1612705,3175304);
        List<Integer> stuIds = Arrays.asList(3975512,3323699,245408,2199863,2408144,2418527,2632891,3322895,3322896,3322897,3896685,3896688,3896724,3896727,3896728,3896729,3896730,3897077,3979162,2835800,3323096,3979003,3306108,3307481,3308296,3976895,3977239,3977409,3977434,3978439,3978449,3979018,3322903,3896708,3976518,3976532,3976928,3976932,3977407,3977459,3306106,3322230,3323088,3319670,3321491,3306103,3318069,3977622,3977624,3977636,3977704,3306107,3306089,3976480,3976482,3976486,3976487,3976488,3976512,3976529,3976530,3976547,3976562,3976567,3976582,3976585,3976589,3976591,3976601,3976603,3976605,3976606,3976609,3976613,3976624,3976628,3976648,3976670,3976684,3976685,3976687,3976688,3976693,3976694,3976695,3976697,3976700,3976702,3976715,3977388,3977403,3977405,3977412,3977414,3977417,3977418,3977436,3977462,3977485,3977487,3978156,3978158,3978230,3896596,3896682,3897076,3325443,3306022,3306110,3306101,3306111,3306136,3306138,3306261,3306149,3306276,3306152,3319616,3308786,3321540,3324535,3324551,3335038,3306283,3319244,3320818,3324306,3325453,3325456,3325460,3325465,3325468,3325545,3326111,3326114,3308300,3308541,3308552,3308475,3308656,3308659,3308661,3308678,3308684,3308710,3308724,3308729,3319516,3322303,3319669,3320786,3320906,3322266,3322357,3323755,3324240,3327792,3978785,3309192,3976743,3976748,3977411,3977423,3977433,3977439,3309349,3309458,3323494,3896716,3323070,3323071,3323545,3896713,3323097,3323694,3323077,3322922,3325195,3325805,3335870,3335873,3896477,3975574,3311667,3317754,3317929,3318220,3321962,3322018,3322214,3322235,3323728,3318347,3319469,3318603,3318617,3318620,3318822,3319621,3323658,3896362,3896366,3319573,3324692,3319971,3319985,3319990,3320551,3320442,3320489,3320608,3320693,3320639,3320696,3320705,3320740,3320775,3320776,3320777,3320779,3320780,3320782,3320787,3320815,3320821,3320828,3320840,3320838,3320845,3320864,3320959,3323023,3323515,3323652,3325397,3325407,3325409,3977520,3321956,3321964,3323056,3323528,3325231,3322374,3322391,3322503,3322587,3323636,3896578,3896581,3896680,3897074,3893159,3977953,3977954,3321529,3321530,3321557,3321966,3322694,3322341,3322249,3322306,3322348,3322312,3322325,3322324,3322379,3322382,3323060,3323646,3323654,3325235,3977489,3322396,3322537,3322565,3322887,3323104,3322574,3322764,3322882,3322747,3322755,3896508,3322907,3322955,3323025,3323499,3323525,3323687,3323705,3323745,3323773,3323750,3323752,3323761,3896248,3896791,3897107,3323807,3896274,3896349,3896358,3896360,3975637,3323808,3896810,3323809,3896741,3323971,3324000,3324023,3324108,3324303,3324715,3325204,3325257,3325441,3325420,3325591,3977618,3326028,3326742,3326907,3328453,3329264,3329423,3329444,3329450,3329456,3329557,3896371,3896867,3897075,3331701,3331706,3331707,3331710,3331717,3331804,3331833,3331853,3331886,3331906,3331989,3330736,3330739,3897106,3978516,3333787,3896721,3975555,3976510,3334278,3977336,3337301,3893447,3895445,3895446,3895453,3896369,3977839,3896375,3975687,3896381,3975659,3975708,3975711,3975713,3896800,3896812,3896813,3896389,3896387,3896585,3896681,3976598,3976616,3978775,3979037,3896787,3896792,3975861,3975922,3975928,3977958,3978005,3976660,3976662,3976353,3976359,3976361,3976714,3976365,3976366,3976375,3976516,3976521,3976556,3976499,3976568,3976637,3976647,3976650,3976657,3976677,3976680,3976682,3976683,3976691,3976750,3976753,3976757,3977523,3977396,3977482,3977402,3977421,3977435,3977479,3977404,3977410,3977441,3977458,3977465,3977468,3977470,3977475,3977476,3977480,3977534,3977845,3977941,3977961,3978422,3978720,3979147,3978787);
        int size = orderDetailIds.size();
        DateTime before = DateTime.now();
        for (int i = 0; i < size; i++) {
            Integer orderDetailId = orderDetailIds.get(i);
            Integer studentId = stuIds.get(i);
            int count = client.getSubmitQuestionCount(orderDetailId, studentId);
        }
        DateTime end = DateTime.now();
        printTimeSpend(before, end, size);
    }

    private void printTimeSpend(DateTime before, DateTime end, int size) {
        int millis = end.millisOfDay().get() - before.millisOfDay().get();
        System.out.println("总耗时: " + millis + "ms");
        System.out.println("平均耗时: " + (millis / size) + "." + (millis % size) + "ms");
    }
}
