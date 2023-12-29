package com.mysys.web.controller.tool;

import com.mysys.common.core.controller.BaseController;
import com.mysys.common.core.domain.R;
import com.mysys.common.utils.StringUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * swagger 用户测试方法
 */
@Tag(name = "用户信息管理")
@RestController
@RequestMapping("/test/user")
public class TestController extends BaseController {
    private final static Map<Integer, UserEntity> users = new LinkedHashMap<Integer, UserEntity>();

    {
        users.put(1, new UserEntity(1, "admin", "admin123", "15888888888"));
        users.put(2, new UserEntity(2, "ry", "admin123", "15666666666"));
    }

    @Operation(summary = "获取用户列表")
    @GetMapping("/list")
    public R<List<UserEntity>> userList() {

        List<UserEntity> userList = new ArrayList<>(users.values());
        return R.ok(userList);
    }

    @Operation(summary = "获取用户详细")
    @Parameter(name = "userId", description = "用户ID", required = true/*, dataType = "int", paramType = "path", dataTypeClass = Integer.class*/)
    @GetMapping("/{userId}")
    public R<UserEntity> getUser(@PathVariable Integer userId) {
        if (!users.isEmpty() && users.containsKey(userId)) {
            return R.ok(users.get(userId));
        } else {
            return R.fail("用户不存在");
        }
    }

    @Operation(summary = "新增用户")
    //@Parameters({
    //    @Parameter(name = "userId", description = "用户id", dataType = "Integer", dataTypeClass = Integer.class),
    //    @Parameter(name = "username", value = "用户名称", dataType = "String", dataTypeClass = String.class),
    //    @Parameter(name = "password", value = "用户密码", dataType = "String", dataTypeClass = String.class),
    //    @Parameter(name = "mobile", value = "用户手机", dataType = "String", dataTypeClass = String.class)
    //})
    @PostMapping("/save")
    public R<String> save(UserEntity user) {
        if (StringUtils.isNull(user) || StringUtils.isNull(user.getUserId())) {
            return R.fail("用户ID不能为空");
        }
        users.put(user.getUserId(), user);
        return R.ok();
    }

    @Operation(summary = "更新用户")
    @PutMapping("/update")
    public R<String> update(@RequestBody UserEntity user) {
        if (StringUtils.isNull(user) || StringUtils.isNull(user.getUserId())) {
            return R.fail("用户ID不能为空");
        }
        if (users.isEmpty() || !users.containsKey(user.getUserId())) {
            return R.fail("用户不存在");
        }
        users.remove(user.getUserId());
        users.put(user.getUserId(), user);
        return R.ok();
    }

    @Operation(summary = "删除用户信息")
    @Parameter(name = "userId", description = "用户ID", required = true/*, dataType = "int", paramType = "path", dataTypeClass = Integer.class*/)
    @DeleteMapping("/{userId}")
    public R<String> delete(@PathVariable Integer userId) {
        if (!users.isEmpty() && users.containsKey(userId)) {
            users.remove(userId);
            return R.ok();
        } else {
            return R.fail("用户不存在");
        }
    }

    // test java 17 and java 21
    public static void main(String[] args) {
        var users = """
                {
                    ""
                }
                """;

        //Animal dog = new Dog("dog");
        //Animal cat = new Cat("cat");
        //
        //if (cat instanceof Dog animal) {
        //    System.out.println(animal.name());
        //}
        List<String> strings = List.of("");
        Map<String, String> stringStringMap = Map.of("", "");

    }

}

//sealed interface Animal permits Bird, Cat, Dog {
//    String name();
//}

//record Bird(String name) implements Animal {}
//record Cat(String name) implements Animal {}
//record Dog(String name) implements Animal {}

@Schema(name = "UserEntity", description = "用户实体")
class UserEntity {
    @Schema(name = "用户ID")
    private Integer userId;

    @Schema(name = "用户名称")
    private String username;

    @Schema(name = "用户密码")
    private String password;

    @Schema(name = "用户手机")
    private String mobile;

    public UserEntity() {

    }

    public UserEntity(Integer userId,
                      String username,
                      String password,
                      String mobile) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

// 23-12-26
//region aspire as pai er
// 渴望
//endregion
//region contribute ken qu bu d
// 贡献
//endregion
//region science sai en s
// 科学
//endregion
//region motherland ma de len d
// 祖国
//endregion
//region the group of students aspired to contribute to the science of their motherland
// 学生团队渴望为祖国的科学事业贡献力量
//endregion

//to be之后需要过去分词

//region interval in te vo
// 间隔
//endregion
//region less
// 较少的
//endregion
//region meter
// 米
//endregion
//region then
// 然后,之后
//endregion
//region between
// 之间
//endregion
//region than
// 对比
//endregion
//region the interval between the two houses is less than one meter
// 两栋房子之间的间隔小于一米
//endregion
//region during ze lin
// 在...期间,中
//endregion
//region during the interval of the show. he took photos with his fans
// 在演出间隙，他和粉丝们拍照留念
//endregion
//region during the interval of the dinner he cooked some vegetable
// 在晚餐间隙，他烹饪了一些蔬菜
//endregion

// 代词“he”通常与第三人称或过去时动词一起使用。

//region debut da bu
// 首演,首次亮相
//endregion
//region album al ben
// 专辑
//endregion
//region sold
// 卖
//endregion
//region million
// 百万
//endregion
//region copies
// 副本
//endregion
//region worldwide
// 全世界
//endregion
//region his debuted album sold one million copies worldwide
// 他的首张专辑在全世界售出了一百万张
//endregion
//region she debuted in 1995
// 她在1995年首次亮相
//endregion
//region at when event did the computer make its debut
// 计算机在哪个事件上首次亮相？
//endregion

//region violate wa er lei t
// 违反,侵犯
//endregion
//region medicine
// 药品
//endregion
//region western
// 西方人
//endregion
//region law
// 法律
//endregion
//region I am sure you will find my medicines violate none of your western laws
// 我确信你会发现我的药品不违反你们任何西方国家的法律
//endregion

//region scholar s 扣 勒
// 学者
//endregion
//region this scholar has set a good example for everyone
// 这位学者为大家树立了一个好榜样
//endregion

//region evaluation e 哇 一 喂 森
// 评估
//endregion
//region ideal i 吊(粤)
// 理想的
//endregion
//region graduate g 啦 组 @
// 毕业
//endregion
//region he did not ideal evaluation when he graduated
// 他毕业时评价不理想
//endregion

//region activation @尾森
// 激活
//endregion
//region software 傻(粤) t 哇
// 软件
//endregion
//region the account cannot be used without activation.
// 该账户未激活无法使用。
//endregion
//region can you please send me the activation code for my software
// 你能发给我软件的激活码吗？
//endregion

//region fit
// 符合,健康的
//endregion
//region jeans 贱(粤) s
// 牛仔裤
//endregion
//region wardrobe 沃 桌 b
// 衣柜
//endregion
//region he runs every morning to keep fit
// 他每天早上跑步保持健康
//endregion
//region the jeans did not fit me
// 这条牛仔裤不合身
//endregion
//region the color of the wardrobe is fit for the room
// 衣柜的颜色与房间相配
//endregion

//region proclaim 婆 可 拦
// 宣布
//endregion
//region accomplishments a com 破 丽 s 门
// 成就
//endregion
//region I wil proclaim it, yea. I will sell it.
// 我会宣扬它，是的。我会卖掉它。
//endregion
//region what better time to proclaim the good news
// 有什么更好的时机宣扬这个好消息呢？
//endregion
//region yet, never will I proclaim my accomplishments
// 然而，我永远不会宣扬我的成就
//endregion

//region broadcaster 不 鹿 卡 s 特
// 广播员
//endregion
//region he is a broadcaster
// 他是一位广播员
//endregion

//region manufacturing 咩 妞 发 缺 灵(粤)
//生产,制造,制造业
//endregion
//region support 四 破 t
// 支持
//endregion
//region country
// 国家
//endregion
//region currently 卡 冷 特 丽
// 当前
//endregion
//region powerhouses
// 强国
//endregion
//region china is one of the manufacturing powerhouses
// 中国是制造业强国之一
//endregion
//region the country is currently supporting manufacturing
// 这个国家当前正支持制造业
//endregion

//region terrify 特 了 快(粤)
// 使害怕，使恐惧，吓，吓坏
//endregion
//region horror 侯 了
// 恐怖
//endregion
//region such
// 这样的
//endregion
//region story
// 故事,历史
//endregion
//region thing
// 事物
//endregion
//region bear 别
// 熊
//endregion
//region he likes tell such horror stories to terrify girls
// 他喜欢讲这样的恐怖故事来吓唬女孩
//endregion
//region there are two thing in the world that terrify me
// 世界上有两件事吓唬我
//endregion
//region I was terrified of bears
// 我对熊感到害怕
//endregion

//2312-27

//region invoke
// 行使,实施,祈求,援引
//endregion
//region chance
// 机会
//endregion
//region interview
// 面试
//endregion
//region tried
// 尝试过,try的过去式
//endregion
//region himself
// 他自己
//endregion
//region I invoked a chance of this interview
// 我请求了这次面试的机会
//endregion
//region do you know how to invoke these resources
// 你知道如何调用这些资源吗？
//endregion
//region he tried to invoke the law by himself
// 他试图自行援引法律
//endregion

//region hostage
// 人质
//endregion
//region you are my hostage now
// 你现在是我的人质
//endregion

// 代词“you”必须与动词的非第三人称形式一起使用。

//region ridiculous
// 荒谬的,可笑的
//endregion
//region costume
// 服装
//endregion
//region happen
// 发生,碰巧
//endregion
//region complete
// 完成,完全的
//endregion
//region completely
// 完全地,十分
//endregion
//region confuse
// 迷惑,混乱
//endregion
//region confused
// 混乱,困惑
//endregion
//region you look ridiculous in this costume
// 你穿这套服装看起来很可笑
//endregion
//region this ridiculous thing is never happen again
// 这种荒谬的事情不会再次发生
//endregion
//region the ridiculous thing happened tonight has completely confused me
// 今晚发生的荒谬事情让我彻底困惑了
//endregion

//region investor in 滑(粤) s 特
// 投资者,投资机构
//endregion
//region ability
// 能力,才能
//endregion
//region collect
// 收集
//endregion
//region analyze 安 娜 赖 z
// 分析
//endregion
//region investors have a strong ability to collect and analyze information
// 投资者有很强的信息收集和分析能力
//endregion
//region government 狗 和(粤) 门
// 政府
//endregion
//region forbid 火(粤) 比
// 禁止
//endregion
//region speculate s 吧 克 勒 t
// 推测,赌钱
//endregion
//region real
// 真正的
//endregion
//region estate a s 剃(粤)
// 房产
//endregion
//region the government forbids investors to speculate in real estate
// 政府禁止投资者炒房
//endregion
//region deceive 得 see
// 欺骗
//endregion
//region deceived
// 受骗
//endregion
//region investors who are too young or too old are more likely to be deceived
// 年龄过小或过大的投资者更容易受骗
//endregion

//region notorious no 特 丽 out s
// 声名狼藉的，臭名昭著的
//endregion
//region mess 咩 s
// 混乱,杂乱
//endregion
//region tourism to 而 森
// 旅游
//endregion
//region the mess in tourism has long been notorious
// 旅游业的乱象早已臭名昭著
//endregion

//region dispute this 漂(粤) 特
// 争论，辩论
//endregion
//region fierce 菲 儿 s
// 激烈的
//endregion
//region inconclusive in 肯 可 鹿 蛇
// 不确定的
//endregion
//region this fierce dispute was inconclusive in the end
// 这场激烈的争论最终不了了之
//endregion

//region fatal
// 致命的
//endregion
//region death
// 死亡
//endregion
//region blow
// 吹,打击
//endregion
//region sick
// 生病
//endregion
//region the death of his father is a fatal blow to the boy
// 他父亲的去世对这个男孩是致命的打击
//endregion
//region I don't wanna get you sick. it could be fatal
// 我不想让你生病。那可能是致命的
//endregion

//region mandatory
// 强制的,命令的,托管的
//endregion
//region tone
// 语气,口吻
//endregion
//region please do not spark to your family in a mandatory tone
// 请不要用命令的口吻和家人讲话
//endregion
//region ask
// 问
//endregion
//region he asked me to be his mandatory to look after his child
// 他请求我成为他的受托人来照顾他的孩子
//endregion
//region visa
// 签证
//endregion
//region foreign
// 外国
//endregion
//region foreigner
// 外国人
// endregion
// region there's mandatory visa for all foreigners
// 所有外国人都需要强制签证
// endregion

//region prescription
//处方,药方
//endregion


//23-12-28
//region unicom u 呢 com
// 联通
//endregion
//region broad b 罗
// 广阔
//endregion
//region swipe s why p
//
//endregion
//region draw 抓
// 画
//endregion
//region pattern 趴 等
// 模式,图案
//endregion
//region finger fin 哥
// 手指
//endregion
//region fingerprint fin 个 p 琳 t
// 指纹
//endregion
//region emergency a 么 阵 屎(粤)
// 紧急事件
//endregion
//region portrait 破 去 t
// 肖像,人像
//endregion
