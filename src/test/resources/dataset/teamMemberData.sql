INSERT INTO client(id, name, source) VALUES
("80460", "Letha241", "Google Adds"),
("19222", "Mollie1975", "Internet"),
("86849", "Quintin5", "Direct"),
("08276", "Kathern49", "Direct"),
("23003", "Felisa221", "Email"),
("68767", "Shenita2027", "Google Adds"),
("47864", "Arnita2004", "Google Adds"),
("44963", "Woodrow2009", "Referral"),
("15878", "Chantel318", NULL),
("40093", "Aisha2010", "Newspaper");

--
-- Inserting data into table user
--
INSERT INTO user(id, country, display_territory, email, first_name, is_external, last_name, line_of_service, pwc_country_code, username) VALUES
(1, NULL, "Q0V6MSUG9SMM68WF7896B8", "GaleL_Elliott@example.com", "Gale", NULL, "Legg", NULL, NULL, NULL),
(2, "United Kingdom", "SI4H2BLPG9E587ELP", "CletusAlford929@nowhere.com", "Kathrine", True, "Noland", "F201D4OFXJ8QSD0EMX466B2WGM7", "GBR", "Gale949"),
(3, "Estonia", "DICPJW05OSFW", "Beatty@nowhere.com", "Rodrick", True, "Hinton", "7SAZ5477", "EST", "Ohara2004"),
(4, "United Kingdom", "2C93O3P34E", "mftalix5377@nowhere.com", "Kareem", False, "Ritchey", "1CIY4Y3ND5PODH9FK5NWYAN8KEAG0K75PX6O5GAQ5T2566WB8B0E7D2081B17K1J4X4490OR34C308X0CC4XHQB24T82", "GBR", "Alonzo512"),
(5, "Panama", "FB05J438ZJOVON6OE17208SL37852790PU89QD", "Marjory.Clemons391@example.com", "Avelina", False, "Nolen", "0Z", "PAN", "Ressie658"),
(6, "South Africa", "S18R6CH", "AllenHeffner446@example.com", "Jerrod", False, "Ritchie", "K5XVAH082206E91C2848XZ781454V6A", "ZAF", "Alva2028"),
(7, "Peru", "6N83840PT7RF2J2694E853", "HaskinsA577@example.com", "Hermila", True, "Leggett", "B2", "PER", "Maki144"),
(8, "Myanmar", NULL, "Archer@example.com", "Deborah", False, "Noonan", "S13E19PHY5", "MMR", "Hoyt334"),
(9, "Mexico", "50B8B1DM6CT5C84DVQGC91S7Z1CGQZW0450XKBE021V853D78YS8O1DJ7U1UX1SMQ", "Upton@example.com", "Alene", False, "Bales", "30U4UFL7W83O7R8SN0C6EGCRF63GS65AD5960QCUW4WEQ3SJSD6NX3X8492340JX5ISPFB0UE675N6NU72Q93CSPS54U31", "MEX", "Desirae866"),
(10, "Georgia", "DM", "Britt@example.com", "Victorina", True, "Hirsch", "03CI98Z3WSHDR8GN73D3F", "GEO", "Bachman1");

--
-- Inserting data into table engagement
--
INSERT INTO engagement(id, engagement_type, line_of_service, name, period_end, period_start, searchable, territory, visible, workspace_type, client_id, created_by, deleted_by) VALUES
("11638", "LQYL881P3ZSNT396Q59C29798MDL2V9L92J7RGW528B6D07134H", "7782C8I43ZWS95AOEX9BT4SCUB3L183RVH4S728N9C8Q0U4MC7NKW0YQV0U43GV82IUM", "Conrad1997", "2007-03-31", "1991-12-04", True, "WX2706O1HVS83MC9P3BR3", True, "JK1", "08276", 3, 7),
("86148", "C3S3F416651XCCD5G", "88XI4E5CAG66579F0DLO082DY04B19TXH96W4A", "Drew9", NULL, "2020-08-18", NULL, "BMO478045Y6JPKAMW7", False, NULL, "40093", 3, 8),
("52432", "LX30948D9AX6T", "ZC4918H63E53084IZK5W36SF10M4TKD", "Kim1953", "1970-10-11", "2012-09-17", True, "4519DA949378HDH6655AUL60Q5I", False, "E7UKXI020499C3L1XC", "80460", 8, 7),
("37879", "Q2D16150MEGZTJ5Z2RLH1U1CY9MLQ6A7F1J816R2O1Z2X1EXGIN1I62B129PWJ93K3543V28CSG2L62A75GMD5207D8I46091550TPQT0OP5Q4K6M8659Z5X9BLA30754R05PLY3YPT6XDW722", "7KB3MW1", "Latonya2022", "1983-01-15", "2019-05-25", False, "26LK2B59274E72YU5163SK83965B3J33QG410H9RW8G59X639ML61NKN5Z8SHSRY937C", True, "DT0R5U1UZKR5446AFUJ55N0F2", "44963", 2, 5),
("87267", "AS1MN4DEW0OO4C12C27A8YL89Y2U1619QRO83Q8V5S5Y0", "EF897LN7YI2452P541O3FO4423VHZP9YU39YN", "Stamm465", "1991-01-24", "2000-03-31", True, "H6U67DJ8ZUW953A0PECZ80LJ94S69YN96L0461SFG", True, "L2404P06C8AK68RH6698J642SJGO3UR616I0QQVXBB720206WQ19D2VYC568N45PIGRU7XB39F0Q14T4W", "08276", 10, 1),
("24206", "Q02C1815MIM1PB6389IM8O081VF3N2FX11A25RO178OC1UB4G12CL6D39860UOUQIF4S", "393JM7E1D2C2X0MP2V9LF89T7J99O5URS798EPL4", "Winkler2019", "2006-07-10", "2006-10-13", False, "8IOA7E6T104RK1P19955TXF5GH9HAKVOUJH3C1HFRV2FAO", False, "7131B47V358826Y6TD7819C70198CDC90", "08276", 6, 8),
("22554", "780FN1Q368KOPU9SV8EY9N8", "363695B1", "Brendan547", "2014-02-09", "1973-01-21", False, "F1AW63GM253F59", False, "2ZOV32C4WY0EJ7G2", "86849", 10, 1),
("93854", "AO24FQBN7B3S516HVJ587PAAC4CFSF4VO1Y01S2K8U7B3", "V7IO590050", "Gino2021", "1972-06-12", "2005-04-13", False, "Y4FL7Q8538XX0", False, "D3WPF2V90", "15878", 8, 3),
("99298", "1O", "4WTO14K2BMFA19V", "Abby664", "2016-05-31", "1971-06-17", True, "9VN059QYV47K7EC4YNY3F1D5868JJ1763", True, "92VE56S94S7QQ7S00", "19222", 9, 2),
("74883", NULL, NULL, "Jolene437", "2003-03-05", NULL, False, NULL, NULL, "U2V4I3HJ10Z0PZ43C9MR1R3N379", "40093", NULL, NULL);

--
-- Inserting data into table team_member
--
INSERT INTO team_member(id, email, name, pwc_guid, engagement_id, user_id) VALUES
(1, "rmfz953@example.com", "Tomas2029", "01251", "52432", 3),
(2, "StuartZ.Kinder@nowhere.com", "Beulah65", "27120", "99298", 7),
(3, "Acker@example.com", "Norbert2018", "96561", "86148", NULL),
(4, "Asbury@example.com", "Elton1957", "23679", "93854", 9),
(5, "nlwccgg0@nowhere.com", "Daniela1984", "15656", "86148", 8),
(6, "Chandler@example.com", "Darling1983", "35715", "52432", 3),
(7, "Bagwell@nowhere.com", "Sweet1967", "75530", "37879", 4),
(8, "Quincy_Angel@example.com", "Abbie682", "58469", "37879", 5),
(9, "Abernathy797@example.com", "Dwain1", "90983", "99298", 2),
(10, "EltonStanton941@nowhere.com", "Burdette1979", "29888", "11638", 1);

--
-- Inserting data into table domain
--
INSERT INTO domain(id, name, engagement_id) VALUES
(1, "Abraham968", "86148"),
(2, "Markus549", "52432"),
(3, "Jason4", "11638"),
(4, "Mcnally2", "11638"),
(5, "Adolph45", "86148"),
(6, NULL, NULL),
(7, "Luther2020", "93854"),
(8, "Ada2005", "74883"),
(9, "Gerardo1992", "52432"),
(10, "Carmela778", "86148");

--
-- Inserting data into table role
--
INSERT INTO role(id, title, team_member_id) VALUES
(1, "K18TQ71R127Y96A0CED6HJAJ53", 6),
(2, "R4K560IO17I9QA77PD56R3IKV7PC6AW", NULL),
(3, "4J", 6),
(4, "TZ72061823453S5MU64S1LO2MO7P28012866TRI74EG96772J", 3),
(5, "6087V19", 8),
(6, "8NVK840093RGXX93QS970Z203", 5),
(7, "H6WTPIE734RZ9E94J4G26SAW", 3),
(8, "51D256LF2G6", 5),
(9, "75R1S86NKL6IXWA2P", 6),
(10, "LF66LLF095HJ739Y7BLOMZ8WBDY5961LASSGZH", 2);

--
-- Inserting data into table user_group
--
INSERT INTO user_group(id, name, user_id) VALUES
(1, "Burleson579", 5),
(2, "Devito2008", 2),
(3, "Ahmed2013", 3),
(4, "Johnathan1980", 6),
(5, "Jay2017", 2),
(6, "Jorge1997", 8),
(7, "Edmond212", 5),
(8, "Roth1988", 5),
(9, "Alarcon2008", 1),
(10, "Abbott2007", NULL);