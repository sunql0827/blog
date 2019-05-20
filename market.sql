/*
Navicat MySQL Data Transfer

Source Server         : sunql
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : market

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-05-18 14:31:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for anthology
-- ----------------------------
DROP TABLE IF EXISTS `anthology`;
CREATE TABLE `anthology` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `add_time` bigint(32) DEFAULT NULL,
  `article_size` int(11) unsigned zerofill DEFAULT NULL,
  `title` varchar(64) DEFAULT NULL,
  `updata_time` bigint(32) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of anthology
-- ----------------------------
INSERT INTO `anthology` VALUES ('00000000003', '1548167316291', '00000000020', '随笔', '1548167316291', 'MnF/9XPJEprPvk/EwSLBAg==');
INSERT INTO `anthology` VALUES ('00000000004', '1549200194750', '00000000001', '2114', '1549200194750', 'MnF/9XPJEprPvk/EwSLBAg==');
INSERT INTO `anthology` VALUES ('00000000015', '1550325731486', '00000000000', '故事', '1550325731486', 'MnF/9XPJEprPvk/EwSLBAg==');
INSERT INTO `anthology` VALUES ('00000000016', '1550326982924', '00000000000', '小说', '1550326982924', 'MnF/9XPJEprPvk/EwSLBAg==');
INSERT INTO `anthology` VALUES ('00000000029', '1556099531591', '00000000000', '散文', '1556099531591', 'MnF/9XPJEprPvk/EwSLBAg==');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `add_time` bigint(20) DEFAULT NULL,
  `art_desc` varchar(15000) DEFAULT NULL,
  `art_title` varchar(64) DEFAULT NULL,
  `art_type` int(11) DEFAULT NULL,
  `comment` int(11) NOT NULL DEFAULT '0',
  `islike` int(11) NOT NULL DEFAULT '0',
  `isread` int(11) unsigned zerofill NOT NULL,
  `is_release` int(11) NOT NULL DEFAULT '0',
  `updata_time` bigint(20) DEFAULT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  `words` int(11) NOT NULL DEFAULT '0',
  `intro` varchar(255) DEFAULT NULL,
  `type` int(11) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('13', '1549200855712', '<div data-note-content=\"\" class=\"show-content\">\n\n			<div class=\"show-content-free\">\n				<h3>前言</h3>\n				<p>全栈工程师，一直以来都是软件行业热议的话题，只要提到全栈工程师大家就觉得很高大上，当然也有人直接说万金油而已，往好听说是全栈工程师，综合能力全，但是实际上就是什么都会哪都不精通。有人唾之以鼻，也有人称赞不已。<br> 对于许多创业公司来讲，全栈工程师也是不错的选择，花一个人钱做一个团队的事何乐而不为呢。所以全栈工程师也就成了仅次于架构师的一个职位。\n				</p>\n				<h3>全栈工程师</h3>\n				<p></p>\n				<p></p>\n				那么什么是全栈工程师呢？大家都各有说辞，有的人说精通前后端，有的人说初级架构师，那么不妨看看百度词条：\n				<p>\n					</p><div class=\"image-view\">\n						<img src=\"http://www.sunql.top/images/image1.jpeg\" width=\"100%\">\n					</div>\n				<p></p>\n\n				<p>其中百度词条也说到全局思维这一点，还有根据这些年我的工作经历，个人认为全局思维才是全栈工程师最核心的一点。<br> 最近不少人说到互联网寒冬的说法，还有不少人说程序员是吃年轻饭的，最多不会超过35岁这业界黄昏点，对此引起不少人的焦虑。其实在我看来这些人云亦云引起的焦虑，其实最主要的原因就是现在企业对程序员的要求越来越高，需要的不仅仅是只会单一技能，企业不再需要只会敲代码的一个工程师。\n					<br> 职场从来都不是平静的，他只会淘汰掉不需要那群人，选出优秀的那一部分进入管理层圈子。古人就说过“近朱者赤，近墨者黑”，跟随优秀的人在一起，就会看到不一样的天空。有些圈子你没进入你就看不到那个圈子里的世界，你就理所当然地认为是寒冬来临。\n					<br> 在IT程序开发这个大环境下，大家都是程序员，如果你拥有全局思维，那么你就是下一个管理者人选，所以你到35岁还是只会代码，或则工作了5年，你依旧只会单一技能，这能怪公司吗？能说寒冬吗？这问题本身在于自己，是你自己给自己画出了寒冬这个怪圈。\n				</p>\n\n				<h5>个人经历</h5>\n				<p>接下来，我从个人经历的角度，说说全栈工程师。<br>\n				</p>\n				<p></p>\n				3年前我进入程序行业，第一时间就把自己的目标定位成了全栈工程师，所以制定了一个3~5年的计划，希望5年之内成为一名全栈工程师，于是我就开始了对全栈之路的摸索之路。\n				<p>\n					</p><div class=\"image-view\"><img src=\"http://www.sunql.top/images/image2.jpg\" width=\"100%\"></div>\n				<p></p>第一年开始Android开发，当时从应用层开发，再到硬件驱动（传感器）开发，虽然如今Android开发有些日落黄昏的节奏，但是这一年带给我的收获也是蛮大的。<br>\n				<p>第二年开始了web前端开发，从H5、CSS3、ES6,再到vue.js、react.js，还有当前比较火的微信小程序，也为我打开了前端的视野。<br> 第三年开始了javaweb的学习，Servlet、Jsp、struts2，spring全家桶等，让我对开发编程有了全新的认知。由此我意识到所有开发都是以数据为导向，尤其对当前人工智能的解释，人工智能就是数据分析。\n					<br> 三年的开发经历，让我从单纯的代码搬运工，逐渐开始对项目思考，对整个项目系统架构思考，08年这一年也开始管理小团队，学会了对项目分析，从需求上审视业务功能，逐步培养自己对于项目的全局思维能力，以及开始考虑产品推广，市场反馈等问题。\n					<br> 之前有群友讨论说，后端开发才是最好晋升管理的首选，目前所有项目经理及管理层，多数都是由管理层转的，当时我就在想，为什么这样，当时我心中答案就是——全局思维。是的，这也就是全栈工程师的核心思维，这一点算是我这三年来的领悟吧。\n					<br> 后台人员相对于前端，移动端，测试，还是有产品而言的，后端人员考虑项目就是项目数据本身，数据就是这个项目的主干。如今的社会是以数据为导向的世界，对于整个软件系统，数据穿插在整个项目中，无论是前端，还是移动端，还是产品或则测试，所以无形中为后端人员培养了全局思维能力，这也是后端人员更容易转管理层的原因。简单讲，全栈工程师就是项目经理进入管理层的首选对象。\n				</p>\n\n				<h3>学习路线</h3>\n				<p></p>\n				<p></p>\n				那么怎么成为全栈工程呢？这也是许多人非常迷茫的问题，大家总认为全栈工程师很神秘，高深莫测的样子，其实并不是那样的神秘，这都是一个知识的积累过程，一步一步积累而来的，下面我们看看下面这张图吧\n				<p>\n					</p><div class=\"image-view\"><img src=\"http://www.sunql.top/images/image3.jpg\" width=\"100%\"></div>\n				<p></p>\n				<p>从上图就可以清楚地看到，全栈工程师需要具备的能力大体分为三类，移动端开发，web前端开发，以及后端开发。也许对于很多人来说，也许就会不由自主地感叹：这些知识太多了吧。我曾经看到过这么一句话：“一名优秀的程序员，一年至少需要学习一门新的程序语言，以应对未来多变的软件行业。”</p>\n\n				<h4>移动端开发</h4>\n				<p>移动端开发就目前而言，需要学习模块主要为Android或者IOS。其中在国内，Android的应用越来越为广泛，智能穿戴，门禁系统，车载电视，家庭网路电视等。以Android移动开发为例需要学习的大纲为：</p>\n				<br>\n				<p>\n					</p><div class=\"image-view\"><img src=\"http://www.sunql.top/images/image4.jpg\" width=\"100%\"></div>\n				<p></p>\n				<p></p>\n				详细知识大纲，如下图所示：\n				<p>\n					</p><div class=\"image-view\"><img src=\"http://www.sunql.top/images/image4.jpg\" width=\"100%\"></div>\n				<p></p>目前Android，大家都说android开发越来越不景气。其实不是，只是企业不再需要初级android人员，如今android也开始倾向于硬件开发，TV电视端开发比较多。android开发选择android studio,ios开发xcode，同时也要学会一些混合开发知识，比如weex,react native,cordova等。\n				<h4>web前端开发</h4>\n				<p></p>\n				<p></p>\n				一般前端开发，多指web前端开发，主要为网页开发，现在同是包含微信小程序开发，前端开发学习大纲分为pc端和移动端，大体学习大纲为：\n				<p>\n					</p><div class=\"image-view\"><img src=\"http://www.sunql.top/images/image2.jpg\" width=\"100%\"></div>\n				<p></p>\n				<p>前端开发目前比较常用开发工具为Hbuilder,vs code,Web Storm等，并且还需要熟悉npm，yarn ,webpack等。</p>\n\n				<h4>后端开发</h4>\n				<p>后端开发目前常用为java,c++,c，python,php等，我这里就列举java后端学习大概方向：</p>\n				<p>\n					</p><div class=\"image-view\"><img src=\"http://www.sunql.top/images/image1.jpeg\" width=\"100%\"></div>\n				<p></p><br> 后端开发而后也分为大数据方向，分布式系统架构方向等，服务器方面后端也要学会常用linux命令，熟悉常用的web应用服务器，如tomcat,Apache ,nginx等，比如C语言，c++相关开发选择vs,java开发选择idea，es等，详细请查看java团长的博客\n				<a href=\"http://www.cnblogs.com/java1024/p/8583274.html\" target=\"_blank\" rel=\"nofollow\">http://www.cnblogs.com/java1024/p/8583274.html</a>，他的体系介绍比较完整。<br> 而后还需要学习其他方面的辅助知识，git,svn等代码版本管理工具。\n				<p></p>\n				<h4>总结</h4>\n				<p>全栈工程师的核心能力就是全局思维，能够独自一人把控整个项目，不像常规单一职责的工程师一样不同的人有不同的看法持一孔之见。因为拥有全局统筹能力，所以全栈工程在未来会更加受到欢迎，同时全栈工程师之路所要学习的东西往往会比单一开发者要多得多，不过付出总会有收获的。如果决定成为一名全栈工程师，就不要在意别人的说辞，坚持走下去，走下去无论最后那份答卷会怎么样，最终的结果都不会令你失望。<br>\n				</p>\n				<p></p>\n				如果说全栈工程师被称作万金油，被认为会很多却不精通，从而被认为油，那么就让把“油”字去掉，成为“万金”工程师，当然也可以不去掉，至于原因火影迷应该都知道“油”。\n				<p>\n					</p><div class=\"image-view\"><img src=\"http://www.sunql.top/images/image2.jpg\" width=\"100%\"></div>\n				<p></p>以上纯属个人见解，如有异议，还望指正。<br>\n				<p>最后奉上一句：</p>\n\n				<h5>未来职场是留给会写作的人，不会写作的人，正在失去你的职场核心竞争力。</h5>\n\n			</div>\n		</div>', '我眼中的全栈工程师', '3', '1', '2', '00000000016', '0', '1550413915384', 'MnF/9XPJEprPvk/EwSLBAg==', '4417', '全栈工程师，一直以来都是软件行业热议的话', '00000000001');
INSERT INTO `article` VALUES ('14', '1550325214706', '<div><span style=\"font-size: 19.2px;\">我想说我有错吗？</span></div><div><span style=\"font-size: 19.2px;\">如果说我没有错，那么是谁让我变成了现在这个样子，</span></div><div><span style=\"font-size: 19.2px;\">我也不愿愿意，我也不想这样。</span></div><div><span style=\"font-size: 19.2px;\">我曾经也想灿烂地笑过，是谁一路把我拉向了深渊。曾经我背着书包，天真以为上学的路上是美好，是谁把我拉到了黑暗角落，对我敲诈勒索，可笑的是，勒索我的那个是还是我同桌的亲哥，是他亲哥，你说可笑不可笑。你以为我愿意接触这样的黑暗吗？</span></div><div><span style=\"font-size: 19.2px;\">我从小就努力地生活着，我想实现自我，我想要活着的样子，我有梦想，我在寒冬自己在淤泥里摸索，我为了自己唯一次生日足足努力了整整半年，我不停地努力着，但是这个社会的黑暗却一次又一次地拿着刺刀扎向我。</span></div><div><span style=\"font-size: 19.2px;\">我想要为家里减轻负担，我想要看看外面的时间，但是那些黑色的爪牙一次又一次地伸手过来，黑中介的指引，我在深夜晕倒在厂房外面，我在40多度火炉城市烤火。我依旧选择努力，我不停地爬起来重新开始。</span></div><div><span style=\"font-size: 19.2px;\">我曾经以为自己很强大的，但是黑手们又向我开了一个玩笑，这是我第一次走进派出所，原来派出所的样子是这样的，冰冷无情，拳打脚踢，所以是我错了？</span></div><div><span style=\"font-size: 19.2px;\">那天从那里出来，天空的太阳特别刺眼.....</span></div><div><span style=\"font-size: 19.2px;\">我开始努力，不再纠结过往，开始开拓自己的生活，我不停地弥补，但是我好像是被生活特别照顾的哪个.....在校招里还能让我遇到医疗诈骗团伙，这是多么有趣的体验，所以我有错吗？这是谁TM的错。</span></div><div><span style=\"font-size: 19.2px;\">绝望，麻木，抑郁，埋汰自我.....一次又一次地让自己坚强，我懦弱地拒绝了一切，结果.....又是电视偶像剧版剧情，绿色出租屋剧情，我曾经很向往爱情，但是这次却败给了金钱，结论来了一个喜当爹,\"我怀了他的孩子，他不想要，但是我想生下来，我可以和你住在一起把孩子生下来吗？\"，一次又一次，真的很有趣。</span></div><div><span style=\"font-size: 19.2px;\">我不停地告诉自己，相信生活，相信未来，相信梦想....</span></div><div><span style=\"font-size: 19.2px;\">但是呢？酒托诈骗，网络诈骗，电信诈骗.....我逃避.....我想要逃避这个黑暗的国度,当我踏出这个世界，迎接我的又是另一篇黑暗，我绝望、我沉沦，我迷茫......我回来再次相信自己，我想再次活一次，但是人生真的很喜欢玩弄于我，传销？1040？这就是曾经所谓朋友，这就是口中的兄弟。</span></div><div><span style=\"font-size: 19.2px;\">我不想拥抱黑暗，但是黑暗每次总是将我带入深渊，我挣扎着，我不停地提醒自己保持清醒。</span></div><div><span style=\"font-size: 19.2px;\">我不想去揭开自己的伤疤，但是体无完肤后，我随处都是伤疤，我想要不去提及，去告诉自己没关系一切都已经过去，但是夜晚每天都会来，夜晚总是那么长，我讨厌黑暗，我憎恶黑暗。</span></div><div><span style=\"font-size: 19.2px;\">我也想拥抱光明，但是光明在哪里？</span></div>', '我有错吗？', '3', '0', '0', '00000000055', '0', '1556098576235', 'MnF/9XPJEprPvk/EwSLBAg==', '1754', '<div><span style=\"fo', '00000000001');
INSERT INTO `article` VALUES ('17', '1550580624914', '<p style=\"box-sizing: border-box; margin: 0px 0px 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px;\">昨天与新同事闲聊，聊起自己从跨出学校门口，一路走过的三年。</p><p style=\"box-sizing: border-box; margin: 0px 0px 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px;\">三年如一日我活成了自己过去嗤之以鼻的样子，当我怡然自得讲述自己过去的辉煌时候，只有自己知道，那只是自己修饰过虚假阅历。</p><p style=\"box-sizing: border-box; margin: 0px 0px 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px;\">如果说有什么成绩，我现在活成了对生活麻木的自己。</p><p style=\"box-sizing: border-box; margin: 0px 0px 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px;\">说真的，我特别羡慕我上家公司的同事，因为他能够毫无压力的每晚上完班后，然后通宵去网吧打游戏，完全不用去考虑我所考虑的生活压力，那样真的很好。</p><p style=\"box-sizing: border-box; margin: 0px 0px 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px;\">还有我的大学室友，他能够辞职后报名去培训公司学习，然后每天回来依旧整天游戏的状态，那种无压力的状态，我的好生羡慕。</p><p style=\"box-sizing: border-box; margin: 0px 0px 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px;\">毫无压力的状态，这大概只有八年前的我，还在读高中的我。或许在三年前我还能开怀大笑，如今确实笑不出来，只剩下假笑，每天对着生活假笑。昨天与新同事闲聊，聊起自己从跨出学校门口，一路走过的三年。</p><p style=\"box-sizing: border-box; margin: 0px 0px 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px;\">三年如一日我活成了自己过去嗤之以鼻的样子，当我怡然自得讲述自己过去的辉煌时候，只有自己知道，那只是自己修饰过虚假阅历。</p><p style=\"box-sizing: border-box; margin: 0px 0px 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px;\">如果说有什么成绩，我现在活成了对生活麻木的自己。</p><p style=\"box-sizing: border-box; margin: 0px 0px 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px;\">说真的，我特别羡慕我上家公司的同事，因为他能够毫无压力的每晚上完班后，然后通宵去网吧打游戏，完全不用去考虑我所考虑的生活压力，那样真的很好。</p><p style=\"box-sizing: border-box; margin: 0px 0px 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px;\">还有我的大学室友，他能够辞职后报名去培训公司学习，然后每天回来依旧整天游戏的状态，那种无压力的状态，我的好生羡慕。</p><p style=\"box-sizing: border-box; margin: 0px 0px 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px;\">毫无压力的状态，这大概只有八年前的我，还在读高中的我。或许在三年前我还能开怀大笑，如今确实笑不出来，只剩下假笑，每天对着生活假笑。昨天与新同事闲聊，聊起自己从跨出学校门口，一路走过的三年。</p><p style=\"box-sizing: border-box; margin: 0px 0px 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px;\"><br></p>', '时去三年往不复', '3', '0', '0', '00000000034', '0', '1556352205936', 'MnF/9XPJEprPvk/EwSLBAg==', '4409', '<p style=\"box-sizing', '00000000001');
INSERT INTO `article` VALUES ('18', '1550581168185', '测试写作保存，写作保存测试', '测试写作', '3', '0', '0', '00000000003', '0', '1550581330232', 'MnF/9XPJEprPvk/EwSLBAg==', '13', '测试写作保存，写作保存测试', '00000000000');
INSERT INTO `article` VALUES ('19', '1550581333336', '<div><div><p>3月5日，闲鱼宣布在GitHub上开源Fish Redux，Fish Redux是一个基于 Redux 数据管理的组装式 flutter 应用框架， 特别适用于构建中大型的复杂应用，它最显著的特征是 函数式的编程模型、可预测的状态管理、可插拔的组件体系、最佳的性能表现。下文中，我们将详细介绍Fish Redux的特点和使用过程，以下内容来自InfoQ独家对闲鱼Flutter团队的采访和Fish Redux的开源文档。</p>\n<h2>开源背景</h2>\n<p>在闲鱼接入Flutter之初，由于我们的落地的方案希望是从最复杂的几个主链路进行尝试来验证flutter完备性的，而我们的详情整体来讲业务比较复杂，主要体现在两个方面：</p>\n<ul>\n<li>页面需要集中状态管理，也就是说页面的不同组件共享一个数据来源，数据来源变化需要通知页面所有组件。</li>\n<li>页面的UI展现形式比较多（如普通详情、闲鱼币详情、社区详情、拍卖详情等），工作量大，所以UI组件需要尽可能复用，也就是说需要比较好的进行组件化切分。</li>\n</ul>\n<p>在我们尝试使用市面上已有的框架（google提供的redux以及bloc）的时候发现，没有任何一个框架可以既解决集中状态管理，又能解决UI的组件化的，因为本身这两个问题有一定的矛盾性（集中vs分治）。因此我们希望有一套框架能解决我们的问题，fish redux应运而生。</p>\n<p>fish redux本身是经过比较多次的迭代的，目前大家看到的版本经过了3次比较大的迭代，实际上也是经过了团队比较多的讨论和思考。</p>\n<p>第一个版本是基于社区内的flutter_redux进行的改造，核心是提供了UI代码的组件化，当然问题也非常明显，针对复杂的详情和发布业务，往往业务逻辑很多，无法做到逻辑代码的组件化。</p>\n<p>第二个版本针对第一个版本的问题，做出了比较重大的修改，解决了UI代码和逻辑代码的分治问题，但同时，按照redux的标准，打破了redux的原则，对于精益求精的闲鱼团队来讲，不能接受；</p>\n<p>因此，在第三个版本进行重构时，我们确立了整体的架构原则与分层要求，一方面按照reduxjs的代码进行了flutter侧的redux实现，将redux的原则完整保留下来。另一方面针对组件化的问题，提供了redux之上的component的封装，并创新的通过这一层的架构设计提供了业务代码分治的能力。</p>\n<p>至此，我们完成了fish redux的基本设计，但在后续的应用中，发现了业务组装以后的代码性能问题，针对该问题，我们再次提供了对应的adapter能力，保障了在长列表场景下的big cell问题。目前，fish redux已经在线上稳定运行超过3个月以上，未来，期待fish redux给社区带来更多的输入。</p></div><br><br>作者：阿里云云栖社区<br>链接：https://www.jianshu.com/p/02f8ab3f6871<br>来源：简书<br>简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。</div>', 'Flutter', '3', '0', '0', '00000000023', '0', '1556099743679', 'MnF/9XPJEprPvk/EwSLBAg==', '1340', '3月5日，闲鱼宣布在GitHub上开源F', '00000000000');
INSERT INTO `article` VALUES ('20', '1550581385624', '测试测试', '测试测试', '3', '0', '0', '00000000006', '0', '1550581591554', 'MnF/9XPJEprPvk/EwSLBAg==', '4', '测试测试', '00000000000');
INSERT INTO `article` VALUES ('21', '1550581594512', '测试初四啊还次啊还饿', '测试比', '3', '0', '0', '00000000234', '0', '1550582045824', 'MnF/9XPJEprPvk/EwSLBAg==', '10', '测试初四啊还次啊还饿', '00000000000');
INSERT INTO `article` VALUES ('22', '1550582032032', '测试测试手动阀手动阀手动阀手动阀撒旦', '测试测试', '3', '0', '0', '00000000543', '0', '1556099677934', 'MnF/9XPJEprPvk/EwSLBAg==', '18', '测试测试手动阀手动阀手动阀手动阀撒旦', '00000000000');
INSERT INTO `article` VALUES ('23', '1550582076848', '测试测试', '测试最新', '3', '0', '0', '00000000234', '0', '1550582206151', 'MnF/9XPJEprPvk/EwSLBAg==', '4', '测试测试', '00000000000');
INSERT INTO `article` VALUES ('24', '1550582210319', '你好你好', '测试测试测试', '3', '0', '0', '00000000234', '0', '1550582234554', 'MnF/9XPJEprPvk/EwSLBAg==', '4', '你好你好', '00000000000');
INSERT INTO `article` VALUES ('25', '1550582247152', '我有一个梦', '每天一个梦', '3', '0', '0', '00000000123', '0', '1556099269799', 'MnF/9XPJEprPvk/EwSLBAg==', '5', '我有一个梦', '00000000000');
INSERT INTO `article` VALUES ('28', '1550906193079', '测试测试测试测试', '测试你好', '0', '0', '0', '00000000001', '0', '1550906237756', '3lB62WC2obOnr8PsZBREdQ==', '8', '测试测试测试测试', '00000000000');
INSERT INTO `article` VALUES ('29', '1550906252013', '加油加油加油', '测试你好', '3', '0', '0', '00000000001', '0', '1551096801312', '3lB62WC2obOnr8PsZBREdQ==', '6', '加油加油加油', '00000000000');
INSERT INTO `article` VALUES ('30', '1551096776444', '开始写文章，你好，这里是测试测试。这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试这里是测试测试。您好你好', '测试文章', '3', '0', '0', '00000000001', '0', '1551353029945', '3lB62WC2obOnr8PsZBREdQ==', '239', '开始写文章，你好，这里是测试测试。这里是', '00000000000');
INSERT INTO `article` VALUES ('31', '1551351923264', '开始写小说。', '小说写作', '27', '0', '0', '00000000001', '0', '1551351993708', '3lB62WC2obOnr8PsZBREdQ==', '6', '开始写小说。', '00000000000');

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `title` varchar(16) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `add_time` bigint(20) DEFAULT NULL,
  `updata_time` bigint(20) DEFAULT NULL,
  `uid` varchar(64) NOT NULL,
  `type` int(2) unsigned zerofill DEFAULT NULL,
  `href` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES ('1', '测试图片1', 'http://169.254.231.96:8080/images/upload/1557665950470.jpg', '1556446740078', '1556446740078', '3lB62WC2obOnr8PsZBREdQ==', '10', 'http://www.sunql.top');
INSERT INTO `banner` VALUES ('2', '测试图片1', 'http://169.254.231.96:8080/images/upload/1557665950470.jpg', '1556446851930', '1556446851930', '3lB62WC2obOnr8PsZBREdQ==', '10', 'http://www.sunql.top');
INSERT INTO `banner` VALUES ('3', '测试图片1', 'http://169.254.231.96:8080/images/upload/1557665950470.jpg', '1556446874228', '1556446874228', '3lB62WC2obOnr8PsZBREdQ==', '10', 'http://www.sunql.top');
INSERT INTO `banner` VALUES ('4', '1557665966163', 'http://169.254.231.96:8080/images/upload/1557665950470.jpg', '1557665966163', '1557665966163', 'MnF/9XPJEprPvk/EwSLBAg==', '01', 'http://www.baidu.com');
INSERT INTO `banner` VALUES ('5', '1557665966163', 'http://169.254.231.96:8080/images/upload/1557665956792.jpg', '1557665966163', '1557665966163', 'MnF/9XPJEprPvk/EwSLBAg==', '01', 'http://www.baidu.com');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `uid` varchar(64) NOT NULL,
  `author` varchar(64) NOT NULL,
  `art_id` int(8) unsigned zerofill NOT NULL,
  `add_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '测试内容', 'MnF/9XPJEprPvk/EwSLBAg==', 'MnF/9XPJEprPvk/EwSLBAg==', '00000013', '1556799536810');
INSERT INTO `comment` VALUES ('2', '我是测试评论', 'MnF/9XPJEprPvk/EwSLBAg==', 'MnF/9XPJEprPvk/EwSLBAg==', '00000013', '1556799820925');
INSERT INTO `comment` VALUES ('3', '再次测试评论', 'MnF/9XPJEprPvk/EwSLBAg==', 'MnF/9XPJEprPvk/EwSLBAg==', '00000013', '1556801816647');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `ipaddress` varchar(32) DEFAULT NULL,
  `loginstate` int(11) NOT NULL,
  `logintime` varchar(32) DEFAULT NULL,
  `outlogintime` varchar(32) DEFAULT NULL,
  `uid` varchar(64) DEFAULT NULL,
  `token` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('1', '192.168.1.1', '1', '1555860602623', null, 'MnF/9XPJEprPvk/EwSLBAg==', 'qRKxEyuu+Qt+w1yklKauXw==');
INSERT INTO `login` VALUES ('2', '192.168.1.1', '1', '1555915518587', null, 'MnF/9XPJEprPvk/EwSLBAg==', '08HcYwEF1p563p9fM/IWsQ==');
INSERT INTO `login` VALUES ('3', '192.168.1.1', '1', '1555915553622', null, 'MnF/9XPJEprPvk/EwSLBAg==', 'G3z0zgEqMXUSdGS2SDb+Ow==');
INSERT INTO `login` VALUES ('4', '192.168.1.1', '1', '1555939385902', null, 'MnF/9XPJEprPvk/EwSLBAg==', 'hcHm5hTgTs53BrznzSq1gQ==');
INSERT INTO `login` VALUES ('5', '192.168.1.1', '1', '1555940192003', null, 'MnF/9XPJEprPvk/EwSLBAg==', '2lSUbr3lR25/vYUC51AXaw==');
INSERT INTO `login` VALUES ('6', '192.168.1.1', '1', '1555940389195', null, 'MnF/9XPJEprPvk/EwSLBAg==', 'G7ZX0CSCkorguPDG08rm1A==');
INSERT INTO `login` VALUES ('7', '192.168.1.1', '1', '1556119756068', null, 'MnF/9XPJEprPvk/EwSLBAg==', 'I9cvvcVvfxiT10btaEuUgw==');
INSERT INTO `login` VALUES ('8', '192.168.1.1', '1', '1556120063371', null, 'MnF/9XPJEprPvk/EwSLBAg==', 'LiocgpBaws4LagJDNqUpjg==');
INSERT INTO `login` VALUES ('9', '192.168.1.1', '1', '1557667892423', null, 'MnF/9XPJEprPvk/EwSLBAg==', 'y9DzarRrRD15D4r0r5Ujsg==');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `add_time` bigint(20) DEFAULT NULL,
  `uid` varchar(64) DEFAULT NULL,
  `updata_time` bigint(20) DEFAULT NULL,
  `user_address` varchar(64) DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  `user_name` varchar(64) DEFAULT NULL,
  `user_phone` bigint(20) DEFAULT NULL,
  `user_photo` varchar(64) DEFAULT NULL,
  `user_pwd` varchar(64) DEFAULT NULL,
  `user_sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1548165788479', 'MnF/9XPJEprPvk/EwSLBAg==', '1548165788479', '杭州西湖区', '18', '测试', '18716643045', 'http://www.sunql.top/images/basephoto.jpeg', '12345678', '1');
INSERT INTO `user` VALUES ('2', '1548167240455', 'oPYJDnQHa5U+vGEpVUSXNQ==', '1548167240455', '杭州西湖区', '18', '测试', '18716643046', 'http://www.sunql.top/images/basephoto.jpeg', '12345678', '1');
INSERT INTO `user` VALUES ('26', '1550901742596', '3lB62WC2obOnr8PsZBREdQ==', '1550901742596', '重庆大足', '18', '测试', '17308354855', null, '12341234', '2');
INSERT INTO `user` VALUES ('27', '1558160757438', '3LU7oSUvMmAdyWQ3v/ji+w==', '1558160757438', '中国', '18', '哈哈', '18716643333', 'http://www.sunql.top/images/basephoto.jpeg', '11112222', '1');
INSERT INTO `user` VALUES ('28', '1558160946386', '1LOz/RqYArYM2tj6gCvs8Q==', '1558160946386', '中国', '18', '哈哈', '187166411111', 'http://www.sunql.top/images/basephoto.jpeg', '11112222', '1');
