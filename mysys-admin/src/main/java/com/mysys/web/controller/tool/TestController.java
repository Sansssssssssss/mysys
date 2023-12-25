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

        List<UserEntity> userList = new ArrayList<UserEntity>(users.values());
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

        Animal dog = new Dog("dog");
        Animal cat = new Cat("cat");

        if (cat instanceof Dog animal) {
            System.out.println(animal.name());
        }
        List<String> strings = List.of("");
        Map<String, String> stringStringMap = Map.of("", "");
    }

}

sealed interface Animal permits Bird, Cat, Dog {
    String name();
}

record Bird(String name) implements Animal {}
record Cat(String name) implements Animal {}
record Dog(String name) implements Animal {}

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
