/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.42 : Database - spbt
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spbt` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `spbt`;

/*Table structure for table `chart_situation_analysis` */

/*Table structure for table `oauth_client_details` */

DROP TABLE IF EXISTS `oauth_client_details`;

CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `authorized_grant_types` varchar(255) DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(255) DEFAULT NULL,
  `autoapprove` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oauth_client_details` */

insert  into `oauth_client_details`(`client_id`,`resource_ids`,`client_secret`,`scope`,`authorized_grant_types`,`web_server_redirect_uri`,`authorities`,`access_token_validity`,`refresh_token_validity`,`additional_information`,`autoapprove`) values ('client',NULL,'{noop}secret','all','password,authorization_code,refresh_token,implicit,client_credentials',NULL,NULL,NULL,NULL,NULL,NULL),('pc',NULL,'{noop}secret','all','password,authorization_code,refresh_token,implicit,client_credentials',NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `rpt_head_code` */

DROP TABLE IF EXISTS `rpt_head_code`;

CREATE TABLE `rpt_head_code` (
  `id` int(11) DEFAULT NULL,
  `rpt_name` varchar(32) DEFAULT NULL COMMENT '报表名称',
  `rpt_code` varchar(32) DEFAULT NULL COMMENT '报表编码',
  `label` varchar(32) DEFAULT NULL COMMENT '标签',
  `prop` varchar(32) DEFAULT NULL COMMENT '列名',
  `state` varchar(10) DEFAULT NULL COMMENT '1 显示',
  `sort` int(11) DEFAULT NULL COMMENT '排序'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rpt_head_code` */

insert  into `rpt_head_code`(`id`,`rpt_name`,`rpt_code`,`label`,`prop`,`state`,`sort`) values (1,NULL,'test_user','用户id','user_id','1',NULL),(2,NULL,'test_user','用户帐号','user_code','1',NULL),(3,NULL,'test_user','用户姓名','user_name','1',NULL),(4,NULL,'test_user','本地网id','latn_id','1',NULL),(5,NULL,'test_user','部门编码','org_code','1',NULL);

/*Table structure for table `sync_data_des` */

DROP TABLE IF EXISTS `sync_data_des`;

CREATE TABLE `sync_data_des` (
  `task_id` int(11) DEFAULT NULL,
  `from_db_column` varchar(100) DEFAULT NULL,
  `to_db_column` varchar(100) DEFAULT NULL,
  `sortby` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sync_data_des` */

/*Table structure for table `sync_data_source` */

DROP TABLE IF EXISTS `sync_data_source`;

CREATE TABLE `sync_data_source` (
  `db_id` int(11) DEFAULT NULL,
  `db_name` varchar(50) DEFAULT NULL,
  `db_ip` varchar(50) DEFAULT NULL,
  `db_username` varchar(50) DEFAULT NULL,
  `db_password` varchar(50) DEFAULT NULL,
  `db_type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sync_data_source` */

insert  into `sync_data_source`(`db_id`,`db_name`,`db_ip`,`db_username`,`db_password`,`db_type`) values (1,'odsdb','jdbc:oracle:thin:@10.1.31.25:1521:odsdb1','xjdsj','31r0GXKq','oracle'),(2,'ywdb','jdbc:oracle:thin:@10.1.33.44:1521:ywdb1','xjdsj','xjdsj_xj587','oracle'),(3,'odsprd','jdbc:oracle:thin:@10.1.31.27:1521:odsdb1','xjhx','xjhx321#','oracle');

/*Table structure for table `sync_data_task` */

DROP TABLE IF EXISTS `sync_data_task`;

CREATE TABLE `sync_data_task` (
  `sync_id` int(11) DEFAULT NULL,
  `sync_name` varchar(50) DEFAULT NULL,
  `from_db_id` varchar(10) DEFAULT NULL,
  `to_db_id` varchar(10) DEFAULT NULL,
  `con_sql` varchar(500) DEFAULT NULL,
  `pre_sql` varchar(500) DEFAULT NULL,
  `status_CD` varchar(100) DEFAULT NULL,
  `sync_desc` varchar(500) DEFAULT NULL,
  `user_tel` varchar(100) DEFAULT NULL,
  `sync_type` varchar(4) DEFAULT NULL,
  `sync_date` varchar(20) DEFAULT NULL,
  `from_table_name` varchar(100) DEFAULT NULL,
  `to_table_name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sync_data_task` */

insert  into `sync_data_task`(`sync_id`,`sync_name`,`from_db_id`,`to_db_id`,`con_sql`,`pre_sql`,`status_CD`,`sync_desc`,`user_tel`,`sync_type`,`sync_date`,`from_table_name`,`to_table_name`) values (2,'cmpps-ywdb-sys_staff','4','1','staff_id =12345','truncate  table sys_staff','1000',NULL,'17392944101','D',NULL,'sys_staff','sys_staff'),(1,'cmpps-ywdb-sys_staff','4','1','staff_id =12345','truncate  table sys_staff','1000',NULL,'17392944101','D',NULL,'sys_staff','sys_staff'),(3,'test_wxp','6','5',NULL,NULL,'1000',NULL,'17392944101','D',NULL,'wxp_test','wxp_test');

/*Table structure for table `sys_config` */

DROP TABLE IF EXISTS `sys_config`;

CREATE TABLE `sys_config` (
  `CONFIG_TYPE` varchar(100) DEFAULT NULL COMMENT '系统配置',
  `CONFIG_KEY` varchar(100) DEFAULT NULL,
  `CONFIG_VALUE` varchar(100) DEFAULT NULL,
  `STATE` varchar(10) DEFAULT NULL COMMENT '1000 正常',
  `remark` varchar(500) DEFAULT NULL COMMENT '描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_config` */

insert  into `sys_config`(`CONFIG_TYPE`,`CONFIG_KEY`,`CONFIG_VALUE`,`STATE`,`remark`) values ('system','INIT_PASSWORD','123456','1000','默认用户密码');

/*Table structure for table `sys_dynamic_sql` */

DROP TABLE IF EXISTS `sys_dynamic_sql`;

CREATE TABLE `sys_dynamic_sql` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `sql_type` varchar(50) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL,
  `result_type` varchar(10) DEFAULT NULL COMMENT '0 实体， 1 list',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `sys_dynamic_sql` */

insert  into `sys_dynamic_sql`(`id`,`code`,`title`,`sql_type`,`content`,`status`,`result_type`) values (1,'allCount','总量','SituationAnalysisMap','SELECT  SUM(cnt_count) AS allCount FROM chart_situation_analysis','1000',NULL),(2,'todayCount','当日总量','SituationAnalysisMap','SELECT  SUM(cnt_count) AS todayCount FROM chart_situation_analysis WHERE   par_acct_day = DATE_FORMAT( NOW(), \'%Y%m%d\' )','1000',NULL),(3,'criminalAllCount','刑事总量','SituationAnalysisMap','SELECT SUM(cnt_count) criminalAllCount FROM chart_situation_analysis WHERE large_type = \'200\' ','1000',NULL),(4,'criminalDayCount','刑事当日','SituationAnalysisMap','SELECT SUM(cnt_count) criminalDayCount FROM chart_situation_analysis WHERE large_type = \'200\' AND par_acct_day=DATE_FORMAT( NOW(), \'%Y%m%d\' )','1000',NULL),(5,'criminalWeekCount','刑事本周','SituationAnalysisMap','SELECT SUM(cnt_count) criminalWeekCount FROM chart_situation_analysis WHERE large_type = \'200\' AND par_acct_day > DATE_FORMAT( DATE_SUB(NOW(),INTERVAL 1 WEEK), \'%Y%m%d\' )','1000',NULL),(6,'criminalMonthCount','刑事本月','SituationAnalysisMap','SELECT SUM(cnt_count) criminalMonthCount FROM chart_situation_analysis WHERE large_type = \'200\' AND par_acct_day > DATE_FORMAT( DATE_SUB(NOW(),INTERVAL 1 MONTH), \'%Y%m%d\' )','1000',NULL),(7,'securityAllCount','治安总量','SituationAnalysisMap','SELECT SUM(cnt_count) securityAllCount FROM chart_situation_analysis WHERE large_type = \'100\' ','1000',NULL),(8,'securityDayCount','治安当日','SituationAnalysisMap','SELECT SUM(cnt_count) securityDayCount FROM chart_situation_analysis WHERE large_type = \'100\' AND par_acct_day=DATE_FORMAT( NOW(), \'%Y%m%d\' )','1000',NULL),(9,'securityWeekCount','治安本周','SituationAnalysisMap','SELECT SUM(cnt_count) securityWeekCount FROM chart_situation_analysis WHERE large_type = \'100\' AND par_acct_day > DATE_FORMAT( DATE_SUB(NOW(),INTERVAL 1 WEEK), \'%Y%m%d\' )','1000',NULL),(10,'securityMonthCount','治安本月','SituationAnalysisMap','SELECT SUM(cnt_count) securityMonthCount FROM chart_situation_analysis WHERE large_type = \'100\' AND par_acct_day > DATE_FORMAT( DATE_SUB(NOW(),INTERVAL 1 MONTH), \'%Y%m%d\' )','1000',NULL),(11,'securityWeekBar','治安周柱状图','securityWeekBar','SELECT a.par_acct_day parAcctDay,a.dayCount,IFNULL(b.chainCount,0)  chainCount ,IFNULL(c.yearOnyearCount,0)  yearOnyearCount  FROM ( SELECT SUM(cnt_count) dayCount ,par_acct_day FROM chart_situation_analysis  WHERE large_type = \'100\' AND par_acct_day > DATE_FORMAT( DATE_SUB(NOW(),INTERVAL 1 WEEK), \'%Y%m%d\' ) GROUP BY par_acct_day ) a LEFT JOIN ( SELECT SUM(cnt_count) chainCount ,par_acct_day ass,par_acct_day+7 AS par_acct_day FROM chart_situation_analysis  WHERE large_type = \'100\' AND par_acct_day > DATE_FORMAT( DATE_SUB(NOW(),INTERVAL 2 WEEK), \'%Y%m%d\' )  AND par_acct_day <= DATE_FORMAT( DATE_SUB(NOW(),INTERVAL 1 WEEK), \'%Y%m%d\' ) GROUP BY par_acct_day ) b ON a.par_acct_day= b.par_acct_day LEFT JOIN  ( SELECT SUM(cnt_count) yearOnyearCount ,DATE_ADD(DATE(par_acct_day) ,INTERVAL 1 YEAR) AS par_acct_day FROM chart_situation_analysis  WHERE large_type = \'100\' AND par_acct_day > DATE_FORMAT( DATE_SUB(DATE_SUB(NOW(),INTERVAL 1 YEAR),INTERVAL 1 WEEK), \'%Y%m%d\' ) AND par_acct_day <= DATE_FORMAT( DATE_SUB(NOW(),INTERVAL 1 YEAR), \'%Y%m%d\' ) GROUP BY par_acct_day ) C ON a.par_acct_day= b.par_acct_day','1000',NULL),(12,'criminalWeekBar','刑事周柱状图','criminalWeekBar','SELECT a.par_acct_day parAcctDay,a.dayCount,IFNULL(b.chainCount,0)  chainCount ,IFNULL(c.yearOnyearCount,0)  yearOnyearCount  FROM ( SELECT SUM(cnt_count) dayCount ,par_acct_day FROM chart_situation_analysis  WHERE large_type = \'200\' AND par_acct_day > DATE_FORMAT( DATE_SUB(NOW(),INTERVAL 1 WEEK), \'%Y%m%d\' ) GROUP BY par_acct_day ) a LEFT JOIN ( SELECT SUM(cnt_count) chainCount ,par_acct_day ass,par_acct_day+7 AS par_acct_day FROM chart_situation_analysis  WHERE large_type = \'200\' AND par_acct_day > DATE_FORMAT( DATE_SUB(NOW(),INTERVAL 2 WEEK), \'%Y%m%d\' )  AND par_acct_day <= DATE_FORMAT( DATE_SUB(NOW(),INTERVAL 1 WEEK), \'%Y%m%d\' ) GROUP BY par_acct_day ) b ON a.par_acct_day= b.par_acct_day LEFT JOIN  ( SELECT SUM(cnt_count) yearOnyearCount ,DATE_ADD(DATE(par_acct_day) ,INTERVAL 1 YEAR) AS par_acct_day FROM chart_situation_analysis  WHERE large_type = \'200\' AND par_acct_day > DATE_FORMAT( DATE_SUB(DATE_SUB(NOW(),INTERVAL 1 YEAR),INTERVAL 1 WEEK), \'%Y%m%d\' ) AND par_acct_day <= DATE_FORMAT( DATE_SUB(NOW(),INTERVAL 1 YEAR), \'%Y%m%d\' ) GROUP BY par_acct_day ) C ON a.par_acct_day= b.par_acct_day','1000',NULL),(13,'policePieBar','派出所极坐标系饼图','policePieBar','SELECT SUM(cnt_count) chartValue, police_name chartName, police_code chartCode FROM chart_situation_analysis WHERE par_acct_day = DATE_FORMAT( NOW(), \'%Y%m%d\' ) GROUP BY police_code , police_name','1000',NULL),(14,'todayTypeCount','今日警情分类汇总','todayTypeCount','SELECT  a.chartName, a.chartCode, a.param1Value chartValue,  CASE WHEN IFNULL(a.param1Value,0) = 0 THEN 0 ELSE ROUND((IFNULL(a.param1Value,0) - IFNULL(b.param2Value,0))*100/ IFNULL(a.param1Value,0)) END AS  ratio FROM  ( SELECT SUM(cnt_count) param1Value,small_type_name  chartName, small_type chartCode  FROM chart_situation_analysis  WHERE par_acct_day = DATE_FORMAT( NOW(), \'%Y%m%d\' )  AND large_type = \'100\' GROUP BY small_type , small_type_name ) a LEFT JOIN  ( SELECT SUM(cnt_count) param2Value,small_type_name  chartName, small_type chartCode  FROM chart_situation_analysis  WHERE par_acct_day = DATE_FORMAT( DATE_SUB(NOW(),INTERVAL 7 DAY), \'%Y%m%d\' )  AND large_type = \'100\' GROUP BY small_type , small_type_name ) b ON a.chartCode= b.chartCode','1000',NULL),(15,'weekTypeCount','本周警情分类','weekTypeCount','SELECT   SUM(cnt_count) chartValue,  small_type_name chartName, small_type chartCode,  CASE WHEN IFNULL( (SELECT   SUM(cnt_count)  FROM chart_situation_analysis  WHERE large_type = \'100\'  AND par_acct_day > DATE_FORMAT( DATE_SUB(NOW(), INTERVAL 1 WEEK), \'%Y%m%d\')),0) = 0 THEN 0  ELSE ROUND( IFNULL(SUM(cnt_count), 0) * 100 /  (SELECT  SUM(cnt_count)  FROM chart_situation_analysis  WHERE large_type = \'100\'  AND par_acct_day > DATE_FORMAT( DATE_SUB(NOW(), INTERVAL 1 WEEK),\'%Y%m%d\'))) END ratio FROM chart_situation_analysis WHERE par_acct_day > DATE_FORMAT( DATE_SUB(NOW(), INTERVAL 1 WEEK),\'%Y%m%d\' )  AND large_type = \'100\' GROUP BY small_type, small_type_name ','1000',NULL);

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名',
  `url` varchar(200) DEFAULT NULL COMMENT 'url',
  `parent_id` int(11) DEFAULT NULL COMMENT '父类id',
  `sort` tinyint(4) DEFAULT NULL COMMENT '排序',
  `remark` text COMMENT '描述',
  `icon` varchar(30) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='系统菜单';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`name`,`url`,`parent_id`,`sort`,`remark`,`icon`) values (1,'系统管理',' ',0,1,NULL,'settings'),(2,'轮播管理',NULL,0,2,NULL,'coffee'),(3,'兴趣管理',NULL,0,3,NULL,'social-reddit-outline'),(4,'发帖管理',NULL,0,4,NULL,'android-chat'),(5,'邮件管理',NULL,0,5,NULL,'ios-email'),(6,'用户管理','/base/user',1,1,NULL,'ios-person'),(7,'菜单管理','/base/menu',1,2,NULL,'android-list'),(8,'角色管理','/base/role',1,3,NULL,'ios-people'),(9,'轮播','/base/banner',2,1,NULL,'coffee'),(10,'新建','/base/interest-create',3,1,NULL,'android-add-circle'),(11,'修改','/base/interest-edit',3,2,NULL,'edit'),(12,'删除','/base/interest-delete',3,3,NULL,'android-remove-circle'),(13,'发帖管理','/base/card',4,1,NULL,'compose'),(14,'邮件','/base/email',5,1,NULL,'email');

/*Table structure for table `sys_permission` */

DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL COMMENT '父节点名称',
  `path` varchar(255) DEFAULT NULL,
  `import_path` varchar(50) DEFAULT NULL COMMENT 'component: () => import',
  `name` varchar(50) DEFAULT NULL,
  `title` varchar(50) NOT NULL COMMENT '名称',
  `icon` varchar(255) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL COMMENT '类型:菜单or功能',
  `perm_code` varchar(50) DEFAULT NULL COMMENT '菜单编码',
  `status` varchar(10) DEFAULT NULL COMMENT '1000',
  `perm_desc` text,
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `url_type` varchar(2) DEFAULT '0' COMMENT '0 系统 1 外部',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

/*Data for the table `sys_permission` */

insert  into `sys_permission`(`permission_id`,`pid`,`path`,`import_path`,`name`,`title`,`icon`,`type`,`perm_code`,`status`,`perm_desc`,`sort`,`url_type`) values (78,NULL,'/sync','','sync','运维管理','icon-fenleiorguangchangorqitatianchong','O',NULL,'1000',NULL,NULL,'0'),(79,78,'tasks','sync/tasks','tasks','同步任务','icon-shoujitianchong','O',NULL,'1000',NULL,1,'0'),(80,78,'dbs','sync/dbs','dbs','数据库管理','icon-shoujitianchong','O',NULL,'1000',NULL,2,'0'),(81,79,NULL,NULL,NULL,'添加',NULL,'F','sync:tasks:add','1000',NULL,NULL,NULL),(82,79,NULL,NULL,NULL,'冻结',NULL,'F','sync:tasks:freeze','1000',NULL,NULL,NULL),(83,NULL,'/sys','','sys','系统管理','icon-fenleiorguangchangorqitatianchong','O',NULL,'1000',NULL,NULL,'0'),(84,83,'user','sys/user','user','用户管理','icon-shoujitianchong','O',NULL,'1000',NULL,1,'0'),(85,83,'permission','sys/permission','menu','权限管理','icon-shoujitianchong','O',NULL,'1000',NULL,2,'0'),(86,83,'role','sys/role','role','角色管理','icon-shoujitianchong','O',NULL,'1000',NULL,NULL,'0'),(87,83,NULL,NULL,NULL,'新增用户',NULL,'F','sys:user:add','1000',NULL,NULL,'0'),(89,NULL,'/charts','','charts','图表','icon-shoujitianchong','O',NULL,'1000',NULL,NULL,'0'),(90,89,'SituationAnalysis','charts/SituationAnalysis','SituationAnalysis','态势图','icon-shoujitianchong','O',NULL,'2000',NULL,NULL,'0');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_code` varchar(50) NOT NULL COMMENT '角色',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `modules` text COMMENT '权限',
  `role_desc` text COMMENT '描述',
  `status` varchar(10) DEFAULT NULL COMMENT '正常1000 禁用1300',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_code`,`role_name`,`modules`,`role_desc`,`status`) values (1,'ROLE_ADMIN','超级管理员','4;5;6;7;8;9;10;11;14;1;12;13;','超级管理员，拥有全部权限。','1000'),(6,'WXP_ROLE','我的角色',NULL,NULL,'1000'),(7,'USER_MANAGER','用户管理角色',NULL,NULL,'1000');

/*Table structure for table `sys_role_permission` */

DROP TABLE IF EXISTS `sys_role_permission`;

CREATE TABLE `sys_role_permission` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` int(11) DEFAULT NULL,
  `PERMISSION_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=297 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_permission` */

insert  into `sys_role_permission`(`ID`,`ROLE_ID`,`PERMISSION_ID`) values (249,7,83),(250,7,84),(251,7,85),(252,7,86),(253,7,87),(270,83,7),(271,84,7),(272,85,7),(273,86,7),(274,87,7),(275,89,7),(276,90,7),(277,78,6),(278,79,6),(279,80,6),(280,81,6),(281,82,6),(282,89,6),(283,90,6),(284,87,6),(285,78,6),(286,79,6),(287,80,6),(288,81,6),(289,82,6),(290,83,6),(291,84,6),(292,85,6),(293,86,6),(294,87,6),(295,89,6),(296,90,6);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `user_code` varchar(50) NOT NULL COMMENT '登录名',
  `password` varchar(225) DEFAULT NULL COMMENT '密码',
  `email` varchar(225) DEFAULT NULL COMMENT '邮箱',
  `usertype` int(1) NOT NULL DEFAULT '0',
  `moble_tel` varchar(225) DEFAULT NULL COMMENT '头像url',
  `state` varchar(225) DEFAULT NULL COMMENT '备用',
  `create_time` varchar(225) DEFAULT NULL COMMENT '注册时间',
  `latn_id` varchar(10) DEFAULT NULL COMMENT '本地网id',
  `org_code` varchar(10) DEFAULT NULL COMMENT '部门编码',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `login_name` (`user_code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户';

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`user_name`,`user_code`,`password`,`email`,`usertype`,`moble_tel`,`state`,`create_time`,`latn_id`,`org_code`) values (1,'管理员','admin','{bcrypt}$2a$10$D8E4cuanLviCCe/ASqBC7OZ84JYOH8IT4/y4JLAV/Pm/AdhzPcy2.','123456@qq.com',0,'17392944101','1000','2019-11-18','888','ASTWSQ1'),(2,'小明','test1','{bcrypt}$2a$10$nr9nTKK2cm1fiGsC.UpGuudc.MtFgthcmRd652ubmrd0TMztB9tym','123456@qq.com',0,'17392944101','1300','2019-11-18','1010','ASTWSQ'),(3,'小刚','test2','{bcrypt}$2a$10$anVOsbvMCJKgmC9pKmoqV.CMqQFktXEzb9KwQ2ILG7FBwlwHBOQwO','123@qq.com',0,'17392944101','1300','2019-11-18','1010','ASTWSQ'),(4,'小红','test3','{bcrypt}$2a$10$m1lHapKhrZ4tH05Jtu.aG.KsZalgTqOVS0MZdOtpfJDPyr9Y71qWG','123321@qq.com',0,'17392944101','1000','2019-11-18','1010','ASTWSQ'),(6,'王鑫鹏','wxp','{bcrypt}$2a$10$D8E4cuanLviCCe/ASqBC7OZ84JYOH8IT4/y4JLAV/Pm/AdhzPcy2.','2111@qq.com',0,'17392944101','1000','2019-11-18','1010','ASTWSQ');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`ID`,`USER_ID`,`ROLE_ID`) values (38,1,6),(39,1,7),(41,17,7),(42,17,6);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
