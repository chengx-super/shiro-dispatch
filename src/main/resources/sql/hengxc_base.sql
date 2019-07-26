/*
 Navicat Premium Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : hengxc_base

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 26/07/2019 18:09:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_base_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_base_dept`;
CREATE TABLE `t_base_dept`  (
  `DEPT_ID` bigint(20) NOT NULL COMMENT '部门ID',
  `PARENT_ID` bigint(20) NOT NULL COMMENT '上级部门ID',
  `DEPT_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `ORDER_NUM` bigint(20) NOT NULL DEFAULT 0 COMMENT '排序',
  `CREATE_TIME` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `MODIFY_TIME` bigint(20) NOT NULL DEFAULT 0 COMMENT '修改时间',
  PRIMARY KEY (`DEPT_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_dept
-- ----------------------------
INSERT INTO `t_base_dept` VALUES (1, 0, '总部', 0, 0, 0);
INSERT INTO `t_base_dept` VALUES (2, 1, '财务部', 0, 0, 0);
INSERT INTO `t_base_dept` VALUES (3, 1, '行政部', 0, 0, 0);
INSERT INTO `t_base_dept` VALUES (4, 1, '开发部', 0, 0, 0);
INSERT INTO `t_base_dept` VALUES (5, 1, '法务部', 0, 0, 0);
INSERT INTO `t_base_dept` VALUES (6, 1, '管理部', 0, 0, 0);
INSERT INTO `t_base_dept` VALUES (7, 1, '后勤部', 0, 0, 0);
INSERT INTO `t_base_dept` VALUES (8, 1, '数据部', 0, 0, 0);
INSERT INTO `t_base_dept` VALUES (9, 1, '测试部', 0, 0, 0);
INSERT INTO `t_base_dept` VALUES (12, 2, '财务3部', 0, 0, 0);
INSERT INTO `t_base_dept` VALUES (13, 2, '财务4部', 0, 0, 0);
INSERT INTO `t_base_dept` VALUES (14, 2, '财务5部', 0, 0, 0);
INSERT INTO `t_base_dept` VALUES (15, 3, '行政2部', 0, 0, 0);
INSERT INTO `t_base_dept` VALUES (16, 3, '行政3部', 0, 0, 0);
INSERT INTO `t_base_dept` VALUES (17, 3, '行政4部', 0, 0, 0);
INSERT INTO `t_base_dept` VALUES (18, 3, '行政5部', 0, 0, 0);

-- ----------------------------
-- Table structure for t_base_log
-- ----------------------------
DROP TABLE IF EXISTS `t_base_log`;
CREATE TABLE `t_base_log`  (
  `ID` bigint(20) NOT NULL COMMENT '日志ID',
  `USERNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作用户',
  `OPERATION` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '操作内容',
  `TIME` decimal(11, 0) NULL DEFAULT NULL COMMENT '耗时',
  `METHOD` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '操作方法',
  `PARAMS` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '方法参数',
  `IP` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作者IP',
  `CREATE_TIME` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `location` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作地点',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_log
-- ----------------------------
INSERT INTO `t_base_log` VALUES (352171778291929088, 'sadmin', '新增定时任务', 75, 'com.hengxc.shiro.job.controller.JobTaskController.addJob()', ' job: \"JobTask(jobId=352171778044465152, beanName=testTask, methodName=test1, params=, cronExpression=0/10 * * * * ?, status=1, remark=, createTime=1564130760552, createTimeFrom=null, createTimeTo=null)\"', '192.168.29.1', 1564130760612, '内网IP|0|0|内网IP|内网IP');
INSERT INTO `t_base_log` VALUES (352180080912502784, 'sadmin', '删除用户', 24, 'com.hengxc.shiro.base.controller.UserController.deleteUsers()', ' userIds: \"11\"', '192.168.29.1', 1564132740111, '内网IP|0|0|内网IP|内网IP');
INSERT INTO `t_base_log` VALUES (352180206787760128, 'sadmin', '新增用户', 20, 'com.hengxc.shiro.base.controller.UserController.addUser()', ' user: \"User(userId=352180206703874048, username=admina, password=7e38870db8cc4be58aae47431a3d75eb, deptId=4, email=, mobile=13062729988, status=1, createTime=1564132770101, modifyTime=null, lastLoginTime=null, sex=0, isTab=1, theme=black, avatar=default.jpg, description=, deptName=null, createTimeFrom=null, createTimeTo=null, roleId=1, roleName=null)\"', '192.168.29.1', 1564132770122, '内网IP|0|0|内网IP|内网IP');
INSERT INTO `t_base_log` VALUES (352180306431840256, 'sadmin', '修改角色', 27, 'com.hengxc.shiro.base.controller.RoleController.updateRole()', ' role: \"Role(roleId=11, roleName=用户管理员, remark=, createTime=null, modifyTime=1564132793853, menuIds=2,8,10,136)\"', '192.168.29.1', 1564132793879, '内网IP|0|0|内网IP|内网IP');
INSERT INTO `t_base_log` VALUES (352180375449112576, 'sadmin', '修改角色', 13, 'com.hengxc.shiro.base.controller.RoleController.updateRole()', ' role: \"Role(roleId=11, roleName=用户管理员, remark=, createTime=null, modifyTime=1564132810319, menuIds=3,11,12,13,160)\"', '192.168.29.1', 1564132810333, '内网IP|0|0|内网IP|内网IP');
INSERT INTO `t_base_log` VALUES (352180434173562880, 'sadmin', '修改角色', 16, 'com.hengxc.shiro.base.controller.RoleController.updateRole()', ' role: \"Role(roleId=11, roleName=用户管理员, remark=, createTime=null, modifyTime=1564132824317, menuIds=1,3,11,12,13,160)\"', '192.168.29.1', 1564132824335, '内网IP|0|0|内网IP|内网IP');
INSERT INTO `t_base_log` VALUES (352184054336065536, 'sadmin', '删除菜单/按钮', 102, 'com.hengxc.shiro.base.controller.MenuController.deleteMenus()', ' menuIds: \"161\"', '192.168.29.1', 1564133687453, '内网IP|0|0|内网IP|内网IP');
INSERT INTO `t_base_log` VALUES (352184088406396928, 'sadmin', '删除菜单/按钮', 8, 'com.hengxc.shiro.base.controller.MenuController.deleteMenus()', ' menuIds: \"162\"', '192.168.29.1', 1564133695572, '内网IP|0|0|内网IP|内网IP');
INSERT INTO `t_base_log` VALUES (352184114847289344, 'sadmin', '删除菜单/按钮', 9, 'com.hengxc.shiro.base.controller.MenuController.deleteMenus()', ' menuIds: \"173\"', '192.168.29.1', 1564133701875, '内网IP|0|0|内网IP|内网IP');
INSERT INTO `t_base_log` VALUES (352184150058471424, 'sadmin', '删除菜单/按钮', 9, 'com.hengxc.shiro.base.controller.MenuController.deleteMenus()', ' menuIds: \"174\"', '192.168.29.1', 1564133710271, '内网IP|0|0|内网IP|内网IP');
INSERT INTO `t_base_log` VALUES (352184175752777728, 'sadmin', '删除菜单/按钮', 25, 'com.hengxc.shiro.base.controller.MenuController.deleteMenus()', ' menuIds: \"125\"', '192.168.29.1', 1564133716397, '内网IP|0|0|内网IP|内网IP');
INSERT INTO `t_base_log` VALUES (352184280161587200, 'sadmin', '删除菜单/按钮', 29, 'com.hengxc.shiro.base.controller.MenuController.deleteMenus()', ' menuIds: \"163,164,170,172\"', '192.168.29.1', 1564133741290, '内网IP|0|0|内网IP|内网IP');
INSERT INTO `t_base_log` VALUES (352184499322359808, 'sadmin', '删除用户', 61, 'com.hengxc.shiro.base.controller.UserController.deleteUsers()', ' userIds: \"1,2,3,4,5,6,7\"', '192.168.29.1', 1564133793541, '内网IP|0|0|内网IP|内网IP');
INSERT INTO `t_base_log` VALUES (352184563398742016, 'sadmin', '修改用户', 28, 'com.hengxc.shiro.base.controller.UserController.updateUser()', ' user: \"User(userId=8, username=null, password=null, deptId=1, email=sadmin@admin.con, mobile=13062728986, status=1, createTime=null, modifyTime=1564133808791, lastLoginTime=null, sex=0, isTab=null, theme=null, avatar=null, description=, deptName=null, createTimeFrom=null, createTimeTo=null, roleId=1, roleName=null)\"', '192.168.29.1', 1564133808819, '内网IP|0|0|内网IP|内网IP');
INSERT INTO `t_base_log` VALUES (352184638808133632, 'sadmin', '执行定时任务', 17, 'com.hengxc.shiro.job.controller.JobTaskController.runJob()', ' jobIds: \"352171778044465152\"', '192.168.29.1', 1564133826798, '内网IP|0|0|内网IP|内网IP');

-- ----------------------------
-- Table structure for t_base_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_base_menu`;
CREATE TABLE `t_base_menu`  (
  `MENU_ID` bigint(20) NOT NULL COMMENT '菜单/按钮ID',
  `PARENT_ID` bigint(20) NOT NULL COMMENT '上级菜单ID',
  `MENU_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单/按钮名称',
  `URL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `PERMS` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '权限标识',
  `ICON` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `TYPE` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型 0菜单 1按钮',
  `ORDER_NUM` bigint(20) NOT NULL DEFAULT 0 COMMENT '排序',
  `CREATE_TIME` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `MODIFY_TIME` bigint(20) NOT NULL DEFAULT 0 COMMENT '修改时间',
  PRIMARY KEY (`MENU_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_menu
-- ----------------------------
INSERT INTO `t_base_menu` VALUES (1, 0, '系统管理', NULL, NULL, 'layui-icon-setting', '0', 1, 0, 0);
INSERT INTO `t_base_menu` VALUES (2, 0, '系统监控', '', '', 'layui-icon-alert', '0', 2, 0, 0);
INSERT INTO `t_base_menu` VALUES (3, 1, '用户管理', '/system/user', 'user:view', 'layui-icon-meh', '0', 1, 0, 0);
INSERT INTO `t_base_menu` VALUES (4, 1, '角色管理', '/system/role', 'role:view', '', '0', 2, 0, 0);
INSERT INTO `t_base_menu` VALUES (5, 1, '菜单管理', '/system/menu', 'menu:view', '', '0', 3, 0, 0);
INSERT INTO `t_base_menu` VALUES (6, 1, '部门管理', '/system/dept', 'dept:view', '', '0', 4, 0, 0);
INSERT INTO `t_base_menu` VALUES (8, 2, '在线用户', '/monitor/online', 'online:view', '', '0', 1, 0, 0);
INSERT INTO `t_base_menu` VALUES (10, 2, '系统日志', '/monitor/log', 'log:view', '', '0', 2, 0, 0);
INSERT INTO `t_base_menu` VALUES (11, 3, '新增用户', NULL, 'user:add', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (12, 3, '修改用户', NULL, 'user:update', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (13, 3, '删除用户', NULL, 'user:delete', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (14, 4, '新增角色', NULL, 'role:add', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (15, 4, '修改角色', NULL, 'role:update', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (16, 4, '删除角色', NULL, 'role:delete', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (17, 5, '新增菜单', NULL, 'menu:add', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (18, 5, '修改菜单', NULL, 'menu:update', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (19, 5, '删除菜单', NULL, 'menu:delete', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (20, 6, '新增部门', NULL, 'dept:add', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (21, 6, '修改部门', NULL, 'dept:update', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (22, 6, '删除部门', NULL, 'dept:delete', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (23, 8, '踢出用户', NULL, 'user:kickout', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (24, 10, '删除日志', NULL, 'log:delete', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (101, 0, '任务调度', NULL, NULL, 'layui-icon-time-circle', '0', 3, 0, 0);
INSERT INTO `t_base_menu` VALUES (102, 101, '定时任务', '/job/job', 'job:view', '', '0', 1, 0, 0);
INSERT INTO `t_base_menu` VALUES (103, 102, '新增任务', NULL, 'job:add', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (104, 102, '修改任务', NULL, 'job:update', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (105, 102, '删除任务', NULL, 'job:delete', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (106, 102, '暂停任务', NULL, 'job:pause', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (107, 102, '恢复任务', NULL, 'job:resume', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (108, 102, '立即执行任务', NULL, 'job:run', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (109, 101, '调度日志', '/job/log', 'job:log:view', '', '0', 2, 0, 0);
INSERT INTO `t_base_menu` VALUES (110, 109, '删除日志', NULL, 'job:log:delete', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (113, 2, 'Redis监控', '/monitor/redis/info', 'redis:view', '', '0', 4, 0, 0);
INSERT INTO `t_base_menu` VALUES (114, 2, 'Redis终端', '/monitor/redis/terminal', 'redis:terminal:view', '', '0', 5, 0, 0);
INSERT INTO `t_base_menu` VALUES (115, 0, '其他模块', NULL, NULL, 'layui-icon-gift', '0', 5, 0, 0);
INSERT INTO `t_base_menu` VALUES (118, 115, '高德地图', '/others/map', 'map:view', '', '0', 3, 0, 0);
INSERT INTO `t_base_menu` VALUES (127, 2, '请求追踪', '/monitor/httptrace', 'httptrace:view', '', '0', 6, 0, 0);
INSERT INTO `t_base_menu` VALUES (128, 2, '系统信息', NULL, NULL, NULL, '0', 7, 0, 0);
INSERT INTO `t_base_menu` VALUES (129, 128, 'JVM信息', '/monitor/jvm', 'jvm:view', '', '0', 1, 0, 0);
INSERT INTO `t_base_menu` VALUES (130, 128, 'Tomcat信息', '/monitor/tomcat', 'tomcat:view', '', '0', 2, 0, 0);
INSERT INTO `t_base_menu` VALUES (131, 128, '服务器信息', '/monitor/server', 'server:view', '', '0', 3, 0, 0);
INSERT INTO `t_base_menu` VALUES (136, 2, '登录日志', '/monitor/loginlog', 'loginlog:view', '', '0', 3, 0, 0);
INSERT INTO `t_base_menu` VALUES (160, 3, '密码重置', NULL, 'user:password:reset', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (165, 138, '修改配置', NULL, 'generator:configure:update', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (166, 139, '生成代码', NULL, 'generator:generate', NULL, '1', 0, 0, 0);
INSERT INTO `t_base_menu` VALUES (171, 136, '删除日志', NULL, 'loginlog:delete', NULL, '1', 0, 0, 0);

-- ----------------------------
-- Table structure for t_base_role
-- ----------------------------
DROP TABLE IF EXISTS `t_base_role`;
CREATE TABLE `t_base_role`  (
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  `ROLE_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `REMARK` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `CREATE_TIME` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `MODIFY_TIME` bigint(20) NOT NULL DEFAULT 0 COMMENT '修改时间',
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_role
-- ----------------------------
INSERT INTO `t_base_role` VALUES (1, '系统管理员', '系统管理员，拥有所有操作权限 ^_^', 0, 0);
INSERT INTO `t_base_role` VALUES (2, '注册账户', '注册账户，拥有查看，新增权限（新增用户除外）和导出Excel权限', 0, 0);
INSERT INTO `t_base_role` VALUES (11, '用户管理员', '', 1564125185104, 1564132824317);
INSERT INTO `t_base_role` VALUES (77, 'Redis监控员', '负责Redis模块', 0, 0);
INSERT INTO `t_base_role` VALUES (78, '系统监控员', '负责整个系统监控模块', 0, 0);

-- ----------------------------
-- Table structure for t_base_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_base_role_menu`;
CREATE TABLE `t_base_role_menu`  (
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  `MENU_ID` bigint(20) NOT NULL COMMENT '菜单/按钮ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_role_menu
-- ----------------------------
INSERT INTO `t_base_role_menu` VALUES (2, 1);
INSERT INTO `t_base_role_menu` VALUES (2, 3);
INSERT INTO `t_base_role_menu` VALUES (2, 161);
INSERT INTO `t_base_role_menu` VALUES (2, 4);
INSERT INTO `t_base_role_menu` VALUES (2, 14);
INSERT INTO `t_base_role_menu` VALUES (2, 162);
INSERT INTO `t_base_role_menu` VALUES (2, 5);
INSERT INTO `t_base_role_menu` VALUES (2, 17);
INSERT INTO `t_base_role_menu` VALUES (2, 163);
INSERT INTO `t_base_role_menu` VALUES (2, 6);
INSERT INTO `t_base_role_menu` VALUES (2, 20);
INSERT INTO `t_base_role_menu` VALUES (2, 164);
INSERT INTO `t_base_role_menu` VALUES (2, 2);
INSERT INTO `t_base_role_menu` VALUES (2, 8);
INSERT INTO `t_base_role_menu` VALUES (2, 10);
INSERT INTO `t_base_role_menu` VALUES (2, 170);
INSERT INTO `t_base_role_menu` VALUES (2, 136);
INSERT INTO `t_base_role_menu` VALUES (2, 172);
INSERT INTO `t_base_role_menu` VALUES (2, 113);
INSERT INTO `t_base_role_menu` VALUES (2, 114);
INSERT INTO `t_base_role_menu` VALUES (2, 127);
INSERT INTO `t_base_role_menu` VALUES (2, 128);
INSERT INTO `t_base_role_menu` VALUES (2, 129);
INSERT INTO `t_base_role_menu` VALUES (2, 130);
INSERT INTO `t_base_role_menu` VALUES (2, 131);
INSERT INTO `t_base_role_menu` VALUES (2, 101);
INSERT INTO `t_base_role_menu` VALUES (2, 102);
INSERT INTO `t_base_role_menu` VALUES (2, 173);
INSERT INTO `t_base_role_menu` VALUES (2, 109);
INSERT INTO `t_base_role_menu` VALUES (2, 174);
INSERT INTO `t_base_role_menu` VALUES (2, 137);
INSERT INTO `t_base_role_menu` VALUES (2, 138);
INSERT INTO `t_base_role_menu` VALUES (2, 139);
INSERT INTO `t_base_role_menu` VALUES (2, 115);
INSERT INTO `t_base_role_menu` VALUES (2, 132);
INSERT INTO `t_base_role_menu` VALUES (2, 133);
INSERT INTO `t_base_role_menu` VALUES (2, 135);
INSERT INTO `t_base_role_menu` VALUES (2, 134);
INSERT INTO `t_base_role_menu` VALUES (2, 126);
INSERT INTO `t_base_role_menu` VALUES (2, 159);
INSERT INTO `t_base_role_menu` VALUES (2, 116);
INSERT INTO `t_base_role_menu` VALUES (2, 117);
INSERT INTO `t_base_role_menu` VALUES (2, 119);
INSERT INTO `t_base_role_menu` VALUES (2, 120);
INSERT INTO `t_base_role_menu` VALUES (2, 121);
INSERT INTO `t_base_role_menu` VALUES (2, 122);
INSERT INTO `t_base_role_menu` VALUES (2, 123);
INSERT INTO `t_base_role_menu` VALUES (2, 118);
INSERT INTO `t_base_role_menu` VALUES (2, 125);
INSERT INTO `t_base_role_menu` VALUES (2, 167);
INSERT INTO `t_base_role_menu` VALUES (2, 168);
INSERT INTO `t_base_role_menu` VALUES (2, 169);
INSERT INTO `t_base_role_menu` VALUES (77, 2);
INSERT INTO `t_base_role_menu` VALUES (77, 113);
INSERT INTO `t_base_role_menu` VALUES (77, 114);
INSERT INTO `t_base_role_menu` VALUES (78, 2);
INSERT INTO `t_base_role_menu` VALUES (78, 8);
INSERT INTO `t_base_role_menu` VALUES (78, 23);
INSERT INTO `t_base_role_menu` VALUES (78, 10);
INSERT INTO `t_base_role_menu` VALUES (78, 24);
INSERT INTO `t_base_role_menu` VALUES (78, 170);
INSERT INTO `t_base_role_menu` VALUES (78, 136);
INSERT INTO `t_base_role_menu` VALUES (78, 171);
INSERT INTO `t_base_role_menu` VALUES (78, 172);
INSERT INTO `t_base_role_menu` VALUES (78, 113);
INSERT INTO `t_base_role_menu` VALUES (78, 114);
INSERT INTO `t_base_role_menu` VALUES (78, 127);
INSERT INTO `t_base_role_menu` VALUES (78, 128);
INSERT INTO `t_base_role_menu` VALUES (78, 129);
INSERT INTO `t_base_role_menu` VALUES (78, 130);
INSERT INTO `t_base_role_menu` VALUES (78, 131);
INSERT INTO `t_base_role_menu` VALUES (1, 1);
INSERT INTO `t_base_role_menu` VALUES (1, 3);
INSERT INTO `t_base_role_menu` VALUES (1, 11);
INSERT INTO `t_base_role_menu` VALUES (1, 12);
INSERT INTO `t_base_role_menu` VALUES (1, 13);
INSERT INTO `t_base_role_menu` VALUES (1, 160);
INSERT INTO `t_base_role_menu` VALUES (1, 161);
INSERT INTO `t_base_role_menu` VALUES (1, 4);
INSERT INTO `t_base_role_menu` VALUES (1, 14);
INSERT INTO `t_base_role_menu` VALUES (1, 15);
INSERT INTO `t_base_role_menu` VALUES (1, 16);
INSERT INTO `t_base_role_menu` VALUES (1, 162);
INSERT INTO `t_base_role_menu` VALUES (1, 5);
INSERT INTO `t_base_role_menu` VALUES (1, 17);
INSERT INTO `t_base_role_menu` VALUES (1, 18);
INSERT INTO `t_base_role_menu` VALUES (1, 19);
INSERT INTO `t_base_role_menu` VALUES (1, 163);
INSERT INTO `t_base_role_menu` VALUES (1, 6);
INSERT INTO `t_base_role_menu` VALUES (1, 20);
INSERT INTO `t_base_role_menu` VALUES (1, 21);
INSERT INTO `t_base_role_menu` VALUES (1, 22);
INSERT INTO `t_base_role_menu` VALUES (1, 164);
INSERT INTO `t_base_role_menu` VALUES (1, 2);
INSERT INTO `t_base_role_menu` VALUES (1, 8);
INSERT INTO `t_base_role_menu` VALUES (1, 23);
INSERT INTO `t_base_role_menu` VALUES (1, 10);
INSERT INTO `t_base_role_menu` VALUES (1, 24);
INSERT INTO `t_base_role_menu` VALUES (1, 170);
INSERT INTO `t_base_role_menu` VALUES (1, 136);
INSERT INTO `t_base_role_menu` VALUES (1, 171);
INSERT INTO `t_base_role_menu` VALUES (1, 172);
INSERT INTO `t_base_role_menu` VALUES (1, 113);
INSERT INTO `t_base_role_menu` VALUES (1, 114);
INSERT INTO `t_base_role_menu` VALUES (1, 127);
INSERT INTO `t_base_role_menu` VALUES (1, 128);
INSERT INTO `t_base_role_menu` VALUES (1, 129);
INSERT INTO `t_base_role_menu` VALUES (1, 130);
INSERT INTO `t_base_role_menu` VALUES (1, 131);
INSERT INTO `t_base_role_menu` VALUES (1, 101);
INSERT INTO `t_base_role_menu` VALUES (1, 102);
INSERT INTO `t_base_role_menu` VALUES (1, 103);
INSERT INTO `t_base_role_menu` VALUES (1, 104);
INSERT INTO `t_base_role_menu` VALUES (1, 105);
INSERT INTO `t_base_role_menu` VALUES (1, 106);
INSERT INTO `t_base_role_menu` VALUES (1, 107);
INSERT INTO `t_base_role_menu` VALUES (1, 108);
INSERT INTO `t_base_role_menu` VALUES (1, 173);
INSERT INTO `t_base_role_menu` VALUES (1, 109);
INSERT INTO `t_base_role_menu` VALUES (1, 110);
INSERT INTO `t_base_role_menu` VALUES (1, 174);
INSERT INTO `t_base_role_menu` VALUES (1, 137);
INSERT INTO `t_base_role_menu` VALUES (1, 138);
INSERT INTO `t_base_role_menu` VALUES (1, 165);
INSERT INTO `t_base_role_menu` VALUES (1, 139);
INSERT INTO `t_base_role_menu` VALUES (1, 166);
INSERT INTO `t_base_role_menu` VALUES (1, 115);
INSERT INTO `t_base_role_menu` VALUES (1, 132);
INSERT INTO `t_base_role_menu` VALUES (1, 133);
INSERT INTO `t_base_role_menu` VALUES (1, 135);
INSERT INTO `t_base_role_menu` VALUES (1, 134);
INSERT INTO `t_base_role_menu` VALUES (1, 126);
INSERT INTO `t_base_role_menu` VALUES (1, 159);
INSERT INTO `t_base_role_menu` VALUES (1, 116);
INSERT INTO `t_base_role_menu` VALUES (1, 117);
INSERT INTO `t_base_role_menu` VALUES (1, 119);
INSERT INTO `t_base_role_menu` VALUES (1, 120);
INSERT INTO `t_base_role_menu` VALUES (1, 121);
INSERT INTO `t_base_role_menu` VALUES (1, 122);
INSERT INTO `t_base_role_menu` VALUES (1, 123);
INSERT INTO `t_base_role_menu` VALUES (1, 118);
INSERT INTO `t_base_role_menu` VALUES (1, 125);
INSERT INTO `t_base_role_menu` VALUES (1, 167);
INSERT INTO `t_base_role_menu` VALUES (1, 168);
INSERT INTO `t_base_role_menu` VALUES (1, 169);
INSERT INTO `t_base_role_menu` VALUES (11, 1);
INSERT INTO `t_base_role_menu` VALUES (11, 3);
INSERT INTO `t_base_role_menu` VALUES (11, 11);
INSERT INTO `t_base_role_menu` VALUES (11, 12);
INSERT INTO `t_base_role_menu` VALUES (11, 13);
INSERT INTO `t_base_role_menu` VALUES (11, 160);

-- ----------------------------
-- Table structure for t_base_user
-- ----------------------------
DROP TABLE IF EXISTS `t_base_user`;
CREATE TABLE `t_base_user`  (
  `USER_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `USERNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `DEPT_ID` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `EMAIL` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `MOBILE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `STATUS` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态 0锁定 1有效',
  `CREATE_TIME` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `MODIFY_TIME` bigint(20) NOT NULL DEFAULT 0 COMMENT '修改时间',
  `LAST_LOGIN_TIME` bigint(20) NOT NULL DEFAULT 0 COMMENT '最近访问时间',
  `SSEX` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别 0男 1女 2保密',
  `IS_TAB` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否开启tab，0关闭 1开启',
  `THEME` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主题',
  `AVATAR` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `DESCRIPTION` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_user
-- ----------------------------
INSERT INTO `t_base_user` VALUES (8, 'sadmin', 'f17e20736df44d5d18c8164f340d8374', 1, 'sadmin@admin.con', '13062728986', '1', 0, 1564133808791, 1564133889567, '0', '1', 'white', 'default.jpg', '');
INSERT INTO `t_base_user` VALUES (352180206703874048, 'admina', '7e38870db8cc4be58aae47431a3d75eb', 4, '', '13062729988', '1', 1564132770101, 0, 0, '0', '1', 'black', 'default.jpg', '');

-- ----------------------------
-- Table structure for t_base_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_base_user_role`;
CREATE TABLE `t_base_user_role`  (
  `USER_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_user_role
-- ----------------------------
INSERT INTO `t_base_user_role` VALUES (9, 1);
INSERT INTO `t_base_user_role` VALUES (352180206703874048, 1);
INSERT INTO `t_base_user_role` VALUES (8, 1);

-- ----------------------------
-- Table structure for t_job_task
-- ----------------------------
DROP TABLE IF EXISTS `t_job_task`;
CREATE TABLE `t_job_task`  (
  `JOB_ID` bigint(20) NOT NULL COMMENT '任务id',
  `BEAN_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'spring bean名称',
  `METHOD_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '方法名',
  `PARAMS` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `CRON_EXPRESSION` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'cron表达式',
  `STATUS` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务状态  0：正常  1：暂停',
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
  PRIMARY KEY (`JOB_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_job_task
-- ----------------------------
INSERT INTO `t_job_task` VALUES (352171778044465152, 'testTask', 'test1', '', '0/10 * * * * ?', '1', '', 1564130760552);

-- ----------------------------
-- Table structure for t_job_task_log
-- ----------------------------
DROP TABLE IF EXISTS `t_job_task_log`;
CREATE TABLE `t_job_task_log`  (
  `LOG_ID` bigint(20) NOT NULL COMMENT '任务日志id',
  `JOB_ID` bigint(20) NOT NULL COMMENT '任务id',
  `BEAN_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'spring bean名称',
  `METHOD_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '方法名',
  `PARAMS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `STATUS` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `ERROR` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '失败信息',
  `TIMES` bigint(20) NULL DEFAULT NULL COMMENT '耗时(单位：毫秒)',
  `CREATE_TIME` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
  PRIMARY KEY (`LOG_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '调度日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_job_task_log
-- ----------------------------
INSERT INTO `t_job_task_log` VALUES (352184639013654528, 352171778044465152, 'testTask', 'test1', '', '0', NULL, 2, 1564133826839);

-- ----------------------------
-- Table structure for t_login_log
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log`  (
  `ID` bigint(20) NOT NULL COMMENT 'id',
  `USERNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `LOGIN_TIME` bigint(20) NOT NULL DEFAULT 0 COMMENT '登录时间',
  `LOCATION` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录地点',
  `IP` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `SYSTEM` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `BROWSER` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '登录日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_login_log
-- ----------------------------
INSERT INTO `t_login_log` VALUES (352173059102347264, 'sadmin', 1564131065980, '内网IP|0|0|内网IP|内网IP', '192.168.29.1', 'Windows 10', 'Chrome 75');
INSERT INTO `t_login_log` VALUES (352173484123754496, 'sadmin', 1564131167313, '内网IP|0|0|内网IP|内网IP', '192.168.29.1', 'Windows 10', 'Chrome 75');
INSERT INTO `t_login_log` VALUES (352178526369222656, 'sadmin', 1564132369478, '内网IP|0|0|内网IP|内网IP', '192.168.29.1', 'Windows 10', 'Chrome 75');
INSERT INTO `t_login_log` VALUES (352180038344511488, 'sadmin', 1564132729962, '内网IP|0|0|内网IP|内网IP', '192.168.29.1', 'Windows 10', 'Chrome 75');

SET FOREIGN_KEY_CHECKS = 1;
