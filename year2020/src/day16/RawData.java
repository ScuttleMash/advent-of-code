package day16;

public class RawData {

    public static final String criteria =
            """
                    departure location: 47-874 or 885-960
                    departure station: 25-616 or 622-964
                    departure platform: 42-807 or 825-966
                    departure track: 36-560 or 583-965
                    departure date: 37-264 or 289-968
                    departure time: 27-325 or 346-954
                    arrival location: 37-384 or 391-950
                    arrival station: 35-233 or 244-963
                    arrival platform: 26-652 or 675-949
                    arrival track: 41-689 or 710-954
                    class: 27-75 or 81-952
                    duration: 45-784 or 807-967
                    price: 40-350 or 374-970
                    route: 30-892 or 904-968
                    row: 47-144 or 151-957
                    seat: 28-750 or 773-973
                    train: 30-456 or 475-950
                    type: 34-642 or 648-968
                    wagon: 42-486 or 498-970
                    zone: 37-152 or 167-973""";

    public static final String myTicket = "83,137,101,73,67,61,103,131,151,127,113,107,109,89,71,139,167,97,59,53";

    public static final String otherTickets =
            """
                    191,477,199,428,5,724,512,212,509,613,193,861,293,595,844,247,136,302,376,252
                    598,628,446,312,180,250,405,54,110,780,829,63,840,404,784,307,254,102,708,637
                    890,168,741,685,143,859,773,914,884,324,924,192,248,906,393,531,414,632,226,862
                    295,174,778,927,523,590,515,62,646,514,483,776,92,185,169,525,60,440,885,104
                    480,849,545,484,525,874,170,551,888,201,596,513,274,743,602,598,616,454,141,452
                    583,179,260,138,624,88,131,480,737,433,194,604,172,393,243,261,128,125,227,873
                    395,204,538,783,540,151,209,203,454,939,975,540,932,246,119,910,120,443,306,552
                    62,62,429,173,453,174,134,169,442,799,109,125,212,866,840,429,833,231,912,292
                    159,527,69,545,677,126,555,324,501,405,297,86,678,395,870,323,186,629,639,866
                    89,744,515,932,406,921,618,536,126,349,61,264,593,445,302,411,406,106,479,93
                    406,395,413,859,584,125,129,100,940,94,451,377,251,992,227,187,523,744,152,217
                    774,87,784,58,417,211,171,547,727,455,516,597,212,224,427,193,526,941,81,76
                    99,294,723,613,71,628,118,56,81,922,72,680,298,616,230,548,259,710,147,247
                    633,676,827,784,400,682,303,504,748,231,843,392,158,126,735,744,321,553,833,176
                    92,384,874,944,290,775,915,479,244,68,403,745,544,258,537,932,776,346,646,913
                    95,111,687,589,195,120,681,193,777,113,261,111,60,530,143,185,61,229,773,815
                    418,914,123,857,289,773,827,475,407,206,504,409,742,386,198,636,632,825,349,863
                    870,129,608,731,534,116,992,425,731,712,583,633,921,69,906,782,58,685,181,685
                    618,250,406,539,679,904,589,197,918,167,259,207,782,316,143,73,52,912,548,71
                    541,71,407,510,71,928,297,509,585,260,324,913,834,174,346,935,603,173,373,523
                    304,912,348,212,683,262,69,303,269,711,727,938,102,738,59,401,928,204,477,739
                    420,207,89,408,784,349,316,885,681,606,55,536,53,526,311,712,915,307,129,11
                    857,101,211,225,975,612,826,377,784,924,510,681,481,916,419,257,484,180,244,885
                    107,537,428,249,406,609,318,622,60,131,291,641,686,174,213,678,738,128,618,117
                    412,304,103,687,316,427,946,734,317,685,74,558,295,172,749,285,58,555,132,449
                    251,614,441,193,64,534,427,308,610,598,103,200,929,215,301,347,738,982,607,589
                    389,436,211,409,537,934,137,177,521,399,869,125,630,776,400,836,186,422,121,724
                    869,248,179,839,378,204,171,174,600,516,614,929,636,80,450,739,256,601,934,683
                    316,86,244,244,838,477,847,502,434,733,143,440,429,712,257,624,676,192,821,375
                    211,387,775,448,61,511,749,712,142,517,863,919,942,526,381,314,108,89,401,724
                    431,264,219,480,890,592,646,350,214,885,347,144,779,180,449,222,780,256,642,558
                    230,540,830,52,194,114,742,908,547,129,932,646,835,438,743,625,865,781,927,888
                    920,226,0,325,136,746,167,453,169,298,737,596,627,776,748,223,887,377,886,391
                    401,557,247,932,512,603,265,510,408,200,651,718,232,780,414,65,105,66,409,171
                    904,320,525,103,594,109,107,593,189,288,480,518,75,748,54,413,114,347,224,829
                    297,426,92,251,541,382,865,829,209,446,452,552,252,366,776,722,720,924,436,747
                    129,197,734,712,866,134,723,180,856,58,886,830,720,868,931,103,556,531,165,547
                    292,737,719,61,61,433,919,832,446,184,314,499,614,846,929,67,715,534,394,147
                    839,945,632,851,145,714,309,905,725,855,246,90,542,383,729,248,447,433,218,939
                    734,949,721,249,324,518,784,437,102,417,55,606,556,728,847,737,560,728,111,385
                    530,114,539,172,595,172,844,384,449,949,676,685,112,555,204,11,651,167,136,143
                    934,777,103,613,426,60,554,321,730,405,786,398,517,858,224,50,775,66,247,652
                    584,840,19,842,131,945,289,551,594,177,588,374,350,926,554,216,718,920,320,597
                    627,510,596,595,301,925,318,835,860,480,451,540,371,97,476,414,258,475,293,502
                    310,435,715,195,210,429,63,296,678,644,143,314,247,233,611,550,505,726,87,507
                    456,541,831,417,486,225,233,105,431,387,846,538,309,207,316,450,196,598,889,410
                    716,183,603,746,878,249,189,222,688,441,847,140,716,678,559,778,891,348,173,407
                    69,910,127,292,521,83,718,594,928,939,870,606,138,61,291,235,184,925,264,868
                    167,478,912,442,736,527,92,542,264,196,652,787,382,614,891,926,54,632,625,438
                    179,499,636,684,936,774,614,524,711,175,85,536,681,639,832,398,383,873,580,583
                    86,433,57,915,407,738,906,186,409,377,482,323,176,11,391,848,779,307,292,683
                    946,227,829,677,339,258,114,245,244,641,478,262,930,504,261,134,529,712,440,938
                    858,723,862,866,436,210,481,826,825,346,614,144,545,310,415,946,604,384,528,568
                    257,861,589,305,611,88,131,684,949,807,317,314,107,882,724,229,88,934,295,230
                    382,559,845,856,638,186,303,713,520,736,126,78,587,318,151,206,936,596,632,405
                    53,378,219,833,306,856,857,833,846,632,651,734,22,550,731,835,311,71,623,685
                    214,304,682,747,186,206,231,316,482,515,406,559,545,595,60,774,6,642,739,294
                    292,890,173,349,591,56,905,416,416,881,84,583,409,217,887,553,252,522,256,591
                    93,397,253,185,252,842,88,916,51,628,932,151,941,162,206,376,857,834,736,304
                    54,246,730,908,560,323,383,526,549,482,870,844,688,338,66,316,486,586,499,531
                    828,122,96,138,136,749,329,605,453,507,535,520,921,588,636,90,121,891,846,889
                    530,143,300,143,63,687,833,711,117,132,500,997,384,303,914,612,936,443,229,230
                    304,126,888,678,390,501,215,89,636,739,220,178,87,232,107,716,317,891,396,943
                    909,883,515,350,221,688,179,604,480,226,135,139,110,862,677,430,408,85,139,63
                    183,538,433,907,229,940,519,98,858,311,479,414,783,469,717,833,196,207,838,559
                    502,856,826,888,515,91,106,200,890,69,290,722,884,784,595,638,888,229,444,449
                    433,854,437,710,105,530,635,748,550,730,23,943,260,549,549,172,95,841,128,595
                    685,606,861,305,105,710,169,120,935,712,50,622,532,54,102,590,484,4,445,224
                    117,505,324,737,212,931,500,138,136,261,400,418,543,241,84,675,686,868,65,905
                    317,143,940,583,711,436,829,248,89,514,445,993,514,445,715,886,556,414,558,301
                    318,739,513,442,511,483,210,224,172,619,939,906,382,778,930,132,436,543,308,298
                    600,906,82,313,505,451,507,500,401,364,777,777,182,450,860,583,719,110,230,919
                    204,109,422,425,633,944,83,544,887,140,647,439,247,448,176,554,521,587,606,609
                    97,868,223,632,551,444,247,779,321,905,119,292,619,597,931,854,558,613,827,829
                    234,217,106,613,508,152,143,486,627,830,448,112,677,99,81,323,607,500,112,826
                    600,591,138,628,818,82,504,315,191,191,779,910,402,206,626,746,775,724,398,719
                    907,917,504,125,829,382,297,633,799,99,102,455,735,710,425,200,933,97,734,612
                    652,719,67,292,651,144,567,296,446,200,906,432,930,916,199,179,262,151,126,419
                    253,730,542,435,928,142,174,933,608,196,196,251,799,749,142,416,904,776,310,515
                    548,298,919,21,906,253,846,838,839,735,62,455,109,622,291,586,777,681,121,718
                    108,90,182,863,831,434,542,346,725,449,98,649,383,828,943,125,202,826,248,372
                    731,941,611,88,223,603,442,917,506,718,374,192,651,610,251,115,445,781,896,67
                    526,726,454,159,110,202,94,480,888,223,623,295,95,605,432,322,455,680,384,319
                    636,254,384,194,422,298,237,58,173,130,402,675,246,727,509,213,833,400,456,505
                    231,529,230,318,256,61,872,716,212,736,682,485,647,132,51,423,711,726,56,446
                    103,848,305,446,746,212,387,75,719,422,604,842,305,479,415,587,727,310,926,612
                    96,317,587,299,131,533,524,548,485,885,611,861,302,756,178,442,847,299,142,886
                    221,168,936,873,946,858,778,624,179,937,441,226,318,444,294,98,852,303,8,632
                    253,890,106,725,374,226,197,375,222,142,863,908,306,645,452,547,934,249,634,518
                    778,548,255,81,254,167,403,932,112,74,191,947,341,530,251,120,216,545,722,948
                    834,204,535,292,836,627,746,91,418,554,379,219,253,231,680,74,689,388,192,51
                    514,832,251,309,645,405,865,920,869,402,255,206,535,478,67,201,843,611,115,542
                    539,231,684,506,988,650,104,480,942,232,453,557,914,93,587,587,909,615,527,632
                    946,541,842,437,577,923,397,232,259,179,832,585,254,309,552,885,613,211,740,175
                    936,303,250,69,627,346,475,454,827,744,544,376,387,782,626,828,914,737,511,922
                    182,873,689,484,319,130,222,247,766,593,121,97,173,424,839,777,184,724,533,552
                    55,650,798,68,536,400,180,479,740,404,834,500,419,775,374,116,107,552,874,601
                    853,498,196,622,866,744,74,217,892,607,946,90,915,121,485,374,939,452,905,647
                    51,136,377,211,87,58,456,831,435,94,294,140,714,523,606,915,733,238,107,144
                    528,112,107,528,541,92,678,478,931,741,712,552,582,834,944,609,609,863,734,119
                    840,240,612,524,249,410,314,847,724,425,132,91,507,311,408,522,174,133,535,57
                    376,63,350,167,555,517,128,942,173,212,303,484,745,675,918,852,19,720,249,400
                    872,455,97,940,348,714,531,946,79,603,638,173,188,180,862,230,593,191,213,930
                    324,685,916,629,923,498,50,449,601,595,183,838,480,845,369,523,138,601,220,207
                    225,316,102,943,80,209,483,112,103,718,70,484,555,888,850,185,780,376,946,101
                    79,947,200,316,844,634,302,382,407,314,501,710,57,859,852,257,375,65,868,774
                    723,727,726,99,254,649,888,591,699,289,83,680,293,597,106,829,312,135,774,516
                    645,588,86,65,594,932,141,62,842,524,213,232,325,738,780,534,777,724,292,186
                    589,193,138,379,397,394,874,557,249,732,75,988,83,55,65,929,710,376,398,394
                    838,75,513,887,127,525,806,229,852,212,211,652,295,783,520,611,214,316,606,932
                    833,259,874,742,440,717,425,555,622,381,873,499,257,244,485,196,531,864,712,700
                    638,444,206,506,538,933,300,615,638,410,776,525,406,481,922,385,827,677,855,302
                    216,749,137,850,262,589,397,53,474,291,680,584,315,516,246,399,730,91,91,289
                    536,829,290,416,316,229,675,946,900,910,865,295,121,62,542,320,71,434,587,113
                    742,629,526,414,721,775,223,377,558,867,549,839,680,721,218,401,838,711,10,944
                    679,541,736,179,181,322,891,403,885,532,313,320,736,738,499,647,350,726,858,92
                    905,627,603,503,741,424,244,597,112,826,212,236,219,138,258,542,189,301,599,82
                    865,734,318,538,912,924,886,982,845,713,297,746,736,611,629,197,648,120,727,534
                    181,415,143,735,622,302,297,502,193,548,614,302,949,203,644,384,611,208,114,864
                    936,734,391,435,830,546,846,181,318,314,214,550,712,15,434,250,642,607,247,622
                    128,637,606,112,304,63,626,407,584,854,167,438,745,251,227,446,786,316,684,419
                    188,426,710,888,827,873,740,651,196,686,734,516,747,931,537,258,748,431,417,158
                    227,120,851,730,429,104,616,256,947,22,221,506,212,207,193,125,929,600,527,739
                    85,805,717,842,55,51,222,250,251,347,321,110,100,629,174,839,686,301,59,55
                    406,435,476,171,132,319,24,734,63,584,537,888,549,318,535,194,888,941,136,721
                    614,527,600,301,258,551,858,263,849,737,70,377,847,680,790,56,485,519,254,323
                    175,113,447,598,115,591,650,434,323,947,430,592,517,677,546,67,221,650,80,448
                    842,52,138,348,313,221,55,612,580,941,170,740,122,63,197,433,840,542,219,923
                    437,733,528,120,604,476,83,161,718,944,191,231,729,636,687,432,199,106,138,374
                    382,360,918,258,205,248,925,444,684,718,591,861,96,734,549,86,223,624,429,590
                    100,314,729,89,780,532,589,843,146,101,204,535,421,201,125,555,553,514,740,382
                    281,501,55,590,230,613,916,887,216,929,608,631,194,924,264,418,455,309,324,410
                    413,855,928,250,935,52,713,258,926,931,499,137,80,128,264,212,626,252,126,302
                    85,675,188,317,741,550,106,784,233,313,531,401,306,843,504,477,995,255,396,742
                    183,130,126,938,624,195,936,540,378,641,554,835,545,0,749,53,262,712,292,478
                    853,117,747,476,621,347,69,686,212,726,905,602,447,747,181,591,482,182,845,748
                    519,244,736,395,70,681,106,560,416,730,82,921,69,407,325,403,306,552,90,287
                    629,524,202,521,377,210,731,542,726,477,615,738,141,146,437,909,202,318,110,437
                    685,248,453,69,718,485,148,946,255,130,191,907,510,325,523,102,636,202,442,736
                    919,87,203,432,110,209,305,318,636,191,85,186,529,571,535,918,222,392,418,611
                    296,407,929,223,922,734,527,77,747,183,711,515,509,533,453,505,300,918,749,82
                    625,260,298,429,61,210,408,628,236,518,869,598,71,550,945,500,122,863,128,101
                    873,857,836,192,784,783,183,253,57,838,63,560,96,725,603,15,885,446,83,127
                    739,424,158,397,430,75,548,784,227,427,830,61,859,552,683,254,552,524,724,416
                    64,184,168,558,742,209,87,212,112,523,632,253,431,68,559,528,685,246,272,505
                    827,128,946,732,717,550,403,646,54,111,744,111,686,717,437,440,83,854,320,525
                    946,643,104,199,262,306,93,641,292,437,434,731,412,393,320,863,933,507,144,313
                    213,130,219,319,441,601,676,349,313,846,587,407,675,503,679,865,483,223,661,307
                    871,225,643,247,639,933,391,775,431,512,885,838,84,831,732,411,417,681,111,930
                    715,737,176,748,196,585,519,90,312,604,780,541,310,536,991,520,209,178,407,171
                    735,200,448,727,189,608,509,194,919,155,606,485,848,516,725,312,731,84,190,510
                    601,477,83,678,833,404,634,506,776,223,54,167,651,982,733,203,522,178,480,831
                    856,498,729,421,252,53,911,171,174,454,86,310,129,169,502,778,485,375,854,879
                    541,685,538,612,394,536,130,513,652,434,124,888,720,696,51,152,103,206,417,230
                    311,193,585,539,126,94,232,556,676,379,480,938,151,635,925,80,427,648,914,188
                    130,186,175,205,55,403,601,906,202,722,843,600,518,348,390,725,628,434,598,410
                    563,108,545,187,439,84,70,939,68,545,714,914,844,177,75,442,912,632,608,103
                    540,624,946,541,736,207,716,236,85,855,909,108,258,67,300,230,588,231,180,98
                    560,511,722,942,51,180,933,598,263,211,522,89,135,617,728,395,58,512,840,63
                    603,251,716,608,378,72,976,264,144,681,506,736,499,248,101,439,67,123,61,439
                    251,57,779,264,101,381,593,546,128,728,936,262,557,133,603,737,630,166,305,591
                    92,259,908,446,937,595,257,588,870,121,252,132,346,215,310,742,346,102,240,455
                    727,584,749,529,841,73,532,100,854,887,428,350,551,861,628,799,857,190,904,923
                    604,629,253,927,583,500,99,323,610,677,259,843,413,178,779,890,129,76,140,526
                    309,448,139,376,184,607,871,635,923,856,550,299,383,97,122,841,486,789,591,595
                    593,177,678,931,95,226,110,904,453,554,979,835,85,68,890,552,483,917,213,934
                    558,858,17,323,891,521,86,859,712,931,436,394,847,294,729,587,374,778,168,936
                    133,214,428,826,597,934,680,522,264,151,249,303,409,81,218,888,479,604,842,617
                    779,517,122,69,167,855,76,827,530,886,512,151,303,231,255,725,176,827,428,135
                    724,842,407,623,945,399,153,291,126,399,376,548,749,374,836,623,259,67,539,439
                    223,613,475,405,478,680,876,182,872,712,111,510,948,250,404,868,84,844,213,230
                    446,155,214,921,224,720,931,118,588,314,923,780,404,118,889,778,425,141,298,100
                    184,584,433,167,518,710,253,198,992,736,188,325,212,925,424,293,537,634,212,509
                    613,555,926,218,552,394,945,679,248,578,726,85,857,260,421,448,174,303,450,129
                    440,486,116,309,855,75,935,604,624,890,648,724,242,304,118,306,174,479,439,783
                    418,640,187,917,296,110,686,73,388,888,395,784,826,527,111,906,123,511,587,835
                    595,257,532,541,108,778,718,552,947,641,616,129,811,584,208,918,603,918,260,949
                    294,554,778,305,716,52,652,259,621,121,191,598,603,593,130,858,837,865,204,447
                    779,418,782,210,417,606,729,676,230,634,641,10,534,63,176,64,630,374,475,852
                    394,233,319,434,124,394,813,936,406,542,225,249,807,710,407,73,525,853,74,244
                    607,193,194,507,407,432,595,548,891,919,312,836,443,560,217,640,542,777,879,295
                    587,890,516,516,874,203,64,59,455,485,174,949,743,175,272,138,676,229,863,413
                    305,861,864,929,749,560,558,131,627,110,128,888,685,783,14,403,715,482,84,347
                    221,868,391,529,155,918,442,640,226,224,257,410,530,545,447,290,417,86,531,920
                    773,77,100,127,182,227,412,634,909,480,675,222,152,745,548,914,209,736,924,547
                    872,15,540,733,304,526,904,553,96,541,534,528,500,448,525,212,541,508,523,603
                    541,742,921,118,440,682,743,104,159,717,689,631,712,198,830,115,425,250,525,303
                    222,408,525,306,352,58,736,417,210,350,316,191,889,303,233,783,230,638,210,530
                    595,870,682,179,374,782,66,401,608,807,867,688,679,849,384,542,190,719,334,292
                    861,302,631,836,187,423,607,414,130,239,584,511,520,941,638,774,480,776,724,481
                    749,249,450,531,732,612,209,637,485,943,97,743,86,499,324,438,913,599,470,228
                    197,594,200,688,144,485,445,874,930,486,774,122,378,740,684,136,167,372,136,261
                    290,914,937,596,60,196,504,682,217,233,151,137,651,50,528,158,433,59,733,854
                    298,630,241,291,289,406,642,404,649,850,711,55,865,208,93,854,445,777,742,605
                    558,476,125,905,255,437,528,2,847,845,717,915,224,601,381,451,782,455,601,216
                    319,96,453,143,502,215,917,433,433,424,589,521,780,382,606,251,155,427,739,81
                    794,115,934,842,213,223,320,689,214,917,218,832,629,610,189,177,728,191,610,177
                    129,890,177,216,400,589,203,641,414,511,262,352,843,261,63,859,849,520,633,104
                    816,207,125,439,407,915,741,86,639,943,60,515,203,186,519,946,783,58,927,835
                    938,939,312,412,608,532,138,841,554,892,540,541,294,260,849,407,143,297,793,392
                    477,612,425,67,983,720,652,914,609,451,511,97,318,827,175,184,627,747,246,91
                    591,174,396,522,793,167,56,831,296,593,91,830,178,831,307,54,504,505,198,554
                    133,217,891,679,201,873,831,190,558,516,2,550,260,637,946,750,299,439,391,605
                    735,252,446,546,606,198,477,742,942,598,86,635,725,258,563,867,946,845,310,485
                    255,943,607,427,380,304,375,202,189,408,684,512,289,374,302,866,104,651,297,242
                    723,255,299,499,548,850,207,744,688,936,782,62,305,436,78,116,218,948,429,73
                    743,732,173,872,559,745,209,556,180,946,908,172,640,864,184,616,933,828,828,998
                    200,411,180,206,480,143,396,57,375,151,713,171,921,317,829,924,322,445,550,329
                    408,640,434,998,590,712,59,213,614,834,712,686,599,850,260,518,418,939,744,835
                    101,714,13,542,928,593,171,536,181,925,907,863,187,302,312,475,541,101,65,179
                    712,526,677,510,128,409,188,524,451,737,904,74,686,801,852,869,481,614,59,428
                    916,534,442,189,172,534,193,802,559,505,409,860,195,682,379,380,325,122,510,66
                    587,51,120,718,249,932,935,595,909,255,248,629,913,632,167,828,152,585,388,215
                    531,93,545,421,842,254,57,932,811,648,775,503,452,531,502,410,254,605,500,308
                    638,400,101,196,226,100,373,613,433,226,478,86,711,425,784,777,443,137,454,95
                    917,887,826,414,832,778,400,133,714,739,394,115,524,823,304,538,308,777,98,436
                    600,507,264,743,439,253,128,599,110,437,159,535,861,398,347,502,889,747,62,313
                    710,108,727,174,285,110,507,248,177,652,454,542,776,932,855,115,622,193,86,189
                    634,501,253,740,59,151,706,403,923,587,719,206,835,99,600,807,298,535,85,923
                    197,224,181,634,109,453,550,546,261,429,396,94,930,615,158,412,541,856,64,546
                    346,916,444,100,640,10,775,868,506,436,94,139,141,890,292,199,687,526,384,845
                    888,231,295,302,774,685,478,639,915,887,187,124,931,392,486,359,731,201,783,527
                    368,633,397,726,59,103,776,483,892,914,931,728,142,933,851,376,245,913,940,348
                    445,774,399,864,498,182,891,742,343,625,172,220,168,640,528,184,89,429,137,57
                    886,453,129,741,545,108,513,182,941,400,608,156,522,517,109,594,741,557,476,931
                    925,90,232,451,176,109,70,726,307,54,935,171,84,711,261,844,739,315,526,804
                    885,296,746,254,239,739,480,375,260,727,376,109,845,179,773,375,123,499,929,194
                    96,84,184,632,141,291,650,782,113,76,948,520,405,377,687,546,226,316,190,832
                    106,288,427,553,446,121,746,87,502,85,518,510,122,322,230,230,293,481,540,445
                    504,830,263,71,912,689,731,855,368,452,530,54,264,558,684,868,445,838,409,478
                    926,680,622,376,841,85,839,727,835,392,478,650,587,71,190,400,743,733,768,549
                    846,203,178,630,675,849,742,438,909,255,867,548,553,167,875,74,213,732,482,85
                    687,746,612,680,717,381,402,317,93,247,860,74,143,743,231,547,182,66,833,465
                    711,119,891,649,509,593,592,306,600,420,414,298,720,276,129,413,891,828,225,178
                    880,257,383,873,382,499,550,60,216,913,94,605,82,928,406,298,854,253,395,318
                    183,940,255,652,182,723,546,634,222,612,99,229,840,719,81,63,62,645,855,380""";
}
