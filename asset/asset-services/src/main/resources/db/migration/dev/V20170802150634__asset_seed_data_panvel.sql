INSERT INTO egasset_asset (id, assetcategory, name, code, department, assetdetails, description, dateofcreation, remarks, length, width, totalarea, modeofacquisition, status, tenantid, zone, revenueward, street, electionward, doorno, pincode, locality, block, properties, createdby, createddate, lastmodifiedby, lastmodifieddate, grossvalue, accumulateddepreciation, assetreference, version) VALUES ((select nextval('seq_egasset_asset')), (select id from egasset_assetcategory where name = 'Shopping Complex' and tenantid = 'panvel'),'Pheonix Complex', (SELECT lpad(nextval('seq_egasset_assetcode')::text,6,'0')), (select id from eg_department where code = 'ACC' and tenantid = 'panvel'), '','Description for Shopping Complex Asset', '2017-06-05 00:00:00', '', '', '', '', 'CONSTRUCTION', 'CAPITALIZED', 'panvel', NULL,123, NULL, 1229, '12/B', 555444, 331, 225, '{"assetAttributes":[{"key":"Shopping Complex No.","type":"Text","value":"4"},{"key":"No. of Floors","type":"Text","value":"1"},{"key":"Total No. of Shops","type":"Text","value":"5"},{"key":"Floor Details","type":"Table","value":[{"Floor No.":"1","No. of Shops":"5"},{"Floor No.":"2","No. of Shops":"5"}]}]}','1', '2017-06-05 06:44:07.649', '1', '2017-06-05 06:44:15.482', 10000, 10000, (select id from egasset_asset where code = '000002' and tenantid = 'panvel'), '1.0');
INSERT INTO egasset_asset (id, assetcategory, name, code, department, assetdetails, description, dateofcreation, remarks, length, width, totalarea, modeofacquisition, status, tenantid, zone, revenueward, street, electionward, doorno, pincode, locality, block, properties, createdby, createddate, lastmodifiedby, lastmodifieddate, grossvalue, accumulateddepreciation, assetreference, version) VALUES ((select nextval('seq_egasset_asset')), (select id from egasset_assetcategory where name = 'Vehicle' and tenantid = 'panvel'), 'MTC Buses', (SELECT lpad(nextval('seq_egasset_assetcode')::text,6,'0')),(select id from eg_department where code = 'ACC' and tenantid = 'panvel'), '', 'Description of Vehicles', NULL, '', '', '', '', 'ACQUIRED', 'CREATED', 'panvel', NULL, 117, NULL, NULL, '', NULL, 391, 141, '{"assetAttributes":[{"key":"Type of Vehicle","type":"Text","value":"Bus"},{"key":"Year of Manufacture","type":"Text","value":"2016"},{"key":"Registration Details","type":"Text","value":"MHJA0381"},{"key":"Engine Number","type":"Text","value":"KL45135"},{"key":"Chassis Number","type":"Text","value":"MH7654"}]}', '1', '2017-08-02 07:02:11.626', '1', '2017-08-02 07:02:11.626', NULL, NULL, NULL, '1.0');
INSERT INTO egasset_asset (id, assetcategory, name, code, department, assetdetails, description, dateofcreation, remarks, length, width, totalarea, modeofacquisition, status, tenantid, zone, revenueward, street, electionward, doorno, pincode, locality, block, properties, createdby, createddate, lastmodifiedby, lastmodifieddate, grossvalue, accumulateddepreciation, assetreference, version) VALUES ((select nextval('seq_egasset_asset')), (select id from egasset_assetcategory where name = 'Street light' and tenantid = 'panvel'), 'Hinjewadi Street Light', (SELECT lpad(nextval('seq_egasset_assetcode')::text,6,'0')),(select id from eg_department where code = 'ACC' and tenantid = 'panvel'), '','Street Lights for Hinjewadi Road', '2017-06-05 00:00:00', '', '', '', '', 'TENDER', 'CREATED', 'panvel', NULL, 33, NULL, 1244, '12/C', 555444, 331, 147, '{"assetAttributes":[{"key":"Road Survey Number","type":"Text","value":"RS34567"},{"key":"Street lighting Category","type":"Select","value":"Street lights"},{"key":"Length of cables used","type":"Text","value":"170"},{"key":"Pole Type","type":"Select","value":"Iron"},{"key":"Source of energy","type":"Select","value":"Electric Power"},{"key":"No of Lamp Posts","type":"Text","value":"25"},{"key":"No. of bulbs in thepost","type":"Text","value":"50"},{"key":"Street Lights Bulbs","type":"Select","value":"Sodium vapour"},{"key":"Cost of lamp posts and erection charges","type":"Text","value":"150"}]}', '1', '2017-06-05 07:03:37.587', '1', '2017-06-05 07:03:46.231', 10000, 10000, NULL, '1.0');
INSERT INTO egasset_asset (id, assetcategory, name, code, department, assetdetails, description, dateofcreation, remarks, length, width, totalarea, modeofacquisition, status, tenantid, zone, revenueward, street, electionward, doorno, pincode, locality, block, properties,	createdby, createddate, lastmodifiedby, lastmodifieddate, grossvalue, accumulateddepreciation, assetreference, version) VALUES ((select nextval('seq_egasset_asset')), (select id from egasset_assetcategory where name = 'Fish Tanks' and tenantid = 'panvel'), 'FishTankAsset', (SELECT lpad(nextval('seq_egasset_assetcode')::text,6,'0')), (select id from eg_department where code = 'ADM' and tenantid = 'panvel'), '','Description for Fish Tank', '2017-06-05 00:00:00', '', '', '', '', 'ACQUIRED', 'CREATED', 'panvel', NULL, 119, NULL, 1237, '124 Door no', 285001, 391, 139, '{"assetAttributes":[{"key":"East","type":"Text","value":"11"},{"key":"South","type":"Text","value":"13"},{"key":"West","type":"Text","value":"15"},{"key":"North","type":"Text","value":"17"},{"key":"Remarks","type":"Text","value":"FishTankAsset"},{"key":"Total Square feet area","type":"Text","value":"500"}]}', '1', '2017-06-05 08:07:54.833', '1', '2017-06-05 08:07:54.833', NULL, NULL, NULL, '1.0');
INSERT INTO egasset_asset (id, assetcategory, name, code, department, assetdetails, description, dateofcreation, remarks, length, width, totalarea, modeofacquisition, status, tenantid, zone, revenueward, street, electionward, doorno, pincode, locality, block, properties,	createdby, createddate, lastmodifiedby, lastmodifieddate, grossvalue, accumulateddepreciation, assetreference, version) VALUES ((select nextval('seq_egasset_asset')), (select id from egasset_assetcategory where name = 'Kalyana Mandapam' and tenantid = 'panvel'),	'Shaadi mahal',( SELECT lpad(nextval('seq_egasset_assetcode')::text,6,'0')), (select id from eg_department where code = 'ACC' and tenantid = 'panvel'), '', '', NULL, '', '', '', '', 'PURCHASE', 'CREATED', 'panvel', NULL, 122, NULL, NULL, '', NULL, 677, 140, '{"assetAttributes":[{"key":"Total Square Feet Area","type":"Text","value":"3500"},{"key":"Total Built up area","type":"Text","value":"3000"}]}', '1', '2017-06-05 09:47:49.486', '1', '2017-06-05 09:47:49.486', NULL, NULL, NULL, '1.0');
INSERT INTO egasset_asset (id, assetcategory, name, code, department, assetdetails, description, dateofcreation, remarks, length, width, totalarea, modeofacquisition, status, tenantid, zone, revenueward, street, electionward, doorno, pincode, locality, block, properties, createdby, createddate, lastmodifiedby, lastmodifieddate, grossvalue, accumulateddepreciation, assetreference, version) VALUES ((select nextval('seq_egasset_asset')), (select id from egasset_assetcategory where name = 'Market' and tenantid = 'panvel'),'Vegetable Market', (SELECT lpad(nextval('seq_egasset_assetcode')::text,6,'0')), (select id from eg_department where code = 'ACC' and tenantid = 'panvel'), '', 'Description for Vegetable Market', '2017-06-05 00:00:00', '','', '', '', 'CONSTRUCTION', 'CAPITALIZED', 'panvel', NULL, 124, NULL, 1230, '12/C', 555444, 331, 226, '{"assetAttributes":[{"key":"Total Square feet area","type":"Text","value":"3590"}]}', '1', '2017-06-05 09:56:31.954', '1', '2017-06-05 09:56:45.61', 10000, 10000, (select id from egasset_asset where code = '000008' and tenantid = 'panvel'), '1.0');
INSERT INTO egasset_asset (id, assetcategory, name, code, department, assetdetails, description, dateofcreation, remarks, length, width, totalarea, modeofacquisition, status, tenantid, zone, revenueward, street, electionward, doorno, pincode, locality, block, properties, createdby, createddate, lastmodifiedby, lastmodifieddate, grossvalue, accumulateddepreciation, assetreference, version) VALUES ((select nextval('seq_egasset_asset')), (select id from egasset_assetcategory where name = 'Lakes and Ponds' and tenantid = 'panvel'), 'Duck Ponds', (SELECT lpad(nextval('seq_egasset_assetcode')::text,6,'0')), 	(select id from eg_department where code = 'ADM' and tenantid = 'panvel'), '', 'Description for Lakes and Ponds Asset', '2017-06-05 00:00:00', '', '', '', '', 'DONATION', 'CAPITALIZED', 'panvel', NULL, NULL, NULL, NULL, '', NULL, 331, NULL, '{"assetAttributes":[{"key":"Area (acre/sqmtr)","type":"Text","value":"2349"}]}', '1', '2017-06-05 10:00:18.094', '1', '2017-06-05 10:00:32.79', 10000, 10000, (select id from egasset_asset where code = '000012' and tenantid = 'panvel'), '1.0');
INSERT INTO egasset_asset (id, assetcategory, name, code, department, assetdetails, description, dateofcreation, remarks, length, width, totalarea, modeofacquisition, status, tenantid, zone, revenueward, street, electionward, doorno, pincode, locality, block, properties, createdby, createddate, lastmodifiedby, lastmodifieddate, grossvalue, accumulateddepreciation, assetreference, version) VALUES ((select nextval('seq_egasset_asset')), (select id from egasset_assetcategory where name = 'Roads' and tenantid = 'panvel'), 'Wakad Road', (SELECT lpad(nextval('seq_egasset_assetcode')::text,6,'0')), (select id from eg_department where code = 'ADM' and tenantid = 'panvel'), '', 'Description for Roads Asset', '2017-06-05 00:00:00', '', '', '', '', 'CONSTRUCTION', 'CAPITALIZED', 'panvel', NULL, NULL, NULL, NULL, '', NULL, 331, NULL, '{"assetAttributes":[{"key":"Road type","type":"Select","value":" concrete road"}]}', '1', '2017-06-05 10:01:17.018', '1', '2017-06-05 10:01:28.922', 10000, 10000, (select id from egasset_asset where code = '000016' and tenantid = 'panvel'), '1.0');
INSERT INTO egasset_asset (id, assetcategory, name, code, department, assetdetails, description, dateofcreation, remarks, length, width, totalarea, modeofacquisition, status, tenantid, zone, revenueward, street, electionward, doorno, pincode, locality, block, properties,	createdby, createddate, lastmodifiedby, lastmodifieddate, grossvalue, accumulateddepreciation, assetreference, version) VALUES ((select nextval('seq_egasset_asset')), (select id from egasset_assetcategory where name = 'Community Toilet Complex' and tenantid = 'panvel'), 'Open  Community Toilet Complex',( SELECT lpad(nextval('seq_egasset_assetcode')::text,6,'0')),(select id from eg_department where code = 'ADM' and tenantid = 'panvel'), '', 'Description for Community Toilet Complex Asset', '2017-06-05 00:00:00', '', '', '', '', 'TENDER', 'CAPITALIZED', 'panvel', NULL, NULL, NULL, NULL, '', NULL, 331, NULL, '{"assetAttributes":[{"key":"Community toilet complex Name","type":"Text","value":"abcd"}]}', '1', '2017-06-05 10:02:11.941', '1', '2017-06-05 10:02:25.151', 10000, 10000, (select id from egasset_asset where code = '000014' and tenantid = 'panvel'), '1.0');
INSERT INTO egasset_asset (id, assetcategory, name, code, department, assetdetails, description, dateofcreation, remarks, length, width, totalarea, modeofacquisition, status, tenantid, zone, revenueward, street, electionward, doorno, pincode, locality, block, properties, createdby, createddate, lastmodifiedby, lastmodifieddate, grossvalue, accumulateddepreciation, assetreference, version) VALUES ((select nextval('seq_egasset_asset')), (select id from egasset_assetcategory where name = 'Usufruct' and tenantid = 'panvel'), 'Open Usufruct', (SELECT lpad(nextval('seq_egasset_assetcode')::text,6,'0')), (select id from eg_department where code = 'ADM' and tenantid = 'panvel'), '', 'Description for Usufruct Asset', '2017-06-05 00:00:00', '', '', '', '', 'PURCHASE', 'CAPITALIZED', 'panvel', NULL, 114, NULL, 1235, '12/D', 555444, 331, 139, '{"assetAttributes":[{"key":"Total Square feet area","type":"Text","value":"4811"}]}', '1', '2017-06-05 10:03:07.51', '1', '2017-06-05 10:03:21.527', 10000, 10000, (select id from egasset_asset where code = '000005' and tenantid = 'panvel'), '1.0');
INSERT INTO egasset_asset (id, assetcategory, name, code, department, assetdetails, description, dateofcreation, remarks, length, width, totalarea, modeofacquisition, status, tenantid, zone, revenueward, street, electionward, doorno, pincode, locality, block, properties, createdby, createddate, lastmodifiedby, lastmodifieddate, grossvalue, accumulateddepreciation, assetreference, version) VALUES ((select nextval('seq_egasset_asset')), (select id from egasset_assetcategory where name = 'Land' and tenantid = 'panvel'), 'Prestige Land', (SELECT lpad(nextval('seq_egasset_assetcode')::text,6,'0')), (select id from eg_department where code = 'ADM' and tenantid = 'panvel'), '', 'Description for Land Asset', '2017-06-05 00:00:00', '', '', '', '', 'ACQUIRED', 'CREATED', 'panvel', NULL, 123, NULL, 1219, '12/A', 555444, 331, 135, '{"assetAttributes":[{"key":"Land Register Number","type":"Text","value":"LReg_612316"},{"key":"OSR Land","type":"Select","value":"Yes"},{"key":"Is it Fenced","type":"Select","value":"Yes"},{"key":"Land Type","type":"Select","value":"Hold"},{"key":"Unit of Measurement","type":"Select","value":"sq. ft."},{"key":"Government order number","type":"Text","value":"GOV_859888"},{"key":"Collector Order Number","type":"Text","value":"CO_457620"},{"key":"Council Resolution Number","type":"Text","value":"CRO_142215"},{"key":"Award Number","type":"Text","value":"A_155188"}]}', '1', '2017-06-05 11:28:00.586', '1', '2017-06-05 11:28:00.586', NULL, NULL, (select id from egasset_asset where code = '000007' and tenantid = 'panvel'), '1.0');
INSERT INTO egasset_asset (id, assetcategory, name, code, department, assetdetails, description, dateofcreation, remarks, length, width, totalarea, modeofacquisition, status, tenantid, zone, revenueward, street, electionward, doorno, pincode, locality, block, properties, createdby, createddate, lastmodifiedby, lastmodifieddate, grossvalue, accumulateddepreciation, assetreference, version) VALUES ((select nextval('seq_egasset_asset')), (select id from egasset_assetcategory where name = 'Market' and tenantid = 'panvel'),'Fruit Market', (SELECT lpad(nextval('seq_egasset_assetcode')::text,6,'0')), (select id from eg_department where code = 'ACC' and tenantid = 'panvel'), '', 'Description for Market Asset', '2017-06-05 00:00:00', '', '','', '', 'CONSTRUCTION', 'CREATED', 'panvel', NULL, 124, NULL, 1230, '12/C', 555444, 331, 226, '{"assetAttributes":[{"key":"Total Square feet area","type":"Text","value":"7267"}]}', '1', '2017-06-05 13:06:14.594', '1', '2017-06-05 13:06:14.594', NULL, NULL, (select id from egasset_asset where code = '000024' and tenantid = 'panvel'), '1.0');



