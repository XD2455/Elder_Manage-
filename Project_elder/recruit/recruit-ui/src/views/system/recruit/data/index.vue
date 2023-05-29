<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">

      <el-form-item label="行业维度" prop="occupied">
        <el-select v-model="queryParams.industry" placeholder="请选择行业维度" clearable size="small">
          <el-option
            v-for="dict in industryDimension"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>

      <el-form-item label="区域维度" prop="occupied">
        <el-select v-model="queryParams.regional" placeholder="请选择区域维度" clearable size="small">
          <el-option
            v-for="dict in regionalDimension"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>

      <el-form-item label="年龄维度" prop="occupied">
        <el-select v-model="queryParams.age" placeholder="请选择年龄维度" clearable size="small">
          <el-option
            v-for="dict in ageDimension"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>


      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleChange">查询图表</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
    <div v-if="yixiangShow">
      <img src="@/assets/images/hangyezongtiyixiangzhanbi.png">
    </div>
    <div v-if="sexShow">
      <img src="@/assets/images/hangyenannvzhanbi.png">
    </div>
    <div v-if="xueliShow">
      <img src="@/assets/images/hangyexueligoucheng.png">
    </div>
    <div v-if="ageShow">
      <img src="@/assets/images/hangyenianlingoucheng.png">
    </div>
    <div v-if="jingyanShow">
      <img src="@/assets/images/gongzuojingyan.png">
    </div>

  </div>
</template>

<script>
import {
  listClassroom,
  getClassroom,
  delClassroom,
  addClassroom,
  updateClassroom,
  exportClassroom
} from "@/api/recruit/classroom";

export default {
  name: "Classroom",
  components: {},
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 教室表格数据
      classroomList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否占用字典
      occupiedOptions: [],
      //行业维度
      industryDimension: [],
      //区域维度
      regionalDimension: [],
      //年龄维度
      ageDimension: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        classroom: null,
        place: null,
        capacity: null,
        occupied: null,
        industry:null,
        regional:null,
        age:null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
      sexShow: false,
      xueliShow: false,
      ageShow: false,
      jingyanShow: false,
      yixiangShow: false,
    };
  },

  created() {
    this.getList();
    this.getDicts("industry_dimension_type").then(response => {
      this.industryDimension = response.data;
    }),
    this.getDicts("regional_dimension_type").then(response => {
      this.regionalDimension = response.data;
    }),
    this.getDicts("age_dimension_type").then(response => {
      this.ageDimension = response.data;
    });
  },
  methods: {
    handleChange() {

      let imgShow = this.industryDimension[this.queryParams.industry].dictLabel
      switch (imgShow) {
        case '各行业总体意向岗位需求占比':
          this.sexShow = false;
          this.xueliShow = false;
          this.ageShow = false;
          this.jingyanShow = false;
          this.yixiangShow = true;
          break;
        case '各行业男女占比':
          this.xueliShow = false;
          this.ageShow = false;
          this.jingyanShow = false;
          this.yixiangShow = false;
          this.sexShow = true;
          break;
        case '各行业学历构成':
          this.ageShow = false;
          this.jingyanShow = false;
          this.yixiangShow = false;
          this.sexShow = false;
          this.xueliShow = true;
          break;
        case '各行业年龄构成':

          this.jingyanShow = false;
          this.yixiangShow = false;
          this.sexShow = false;
          this.xueliShow = false;
          this.ageShow = true;
          break;
        case '各行业工作经验构成':
          this.yixiangShow = false;
          this.sexShow = false;
          this.xueliShow = false;
          this.ageShow = false;
          this.jingyanShow = true;
          break;
        default:
          this.yixiangShow = false;
          this.sexShow = false;
          this.xueliShow = false;
          this.ageShow = false;
          this.jingyanShow = false;
          break;
      }

    },
    getList() {
      this.loading = true;
      listClassroom(this.queryParams).then(response => {
        this.classroomList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 是否占用字典翻译
    occupiedFormat(row, column) {
      return this.selectDictLabel(this.occupiedOptions, row.occupied);
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        classroom: null,
        place: null,
        capacity: null,
        occupied: null,
        industry:null,
        regional:null,
        age:null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加教室";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getClassroom(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改场地";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateClassroom(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addClassroom(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除教室编号为"' + ids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function () {
        return delClassroom(ids);
      }).then(() => {
        this.getList();
        this.msgSuccess("删除成功");
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有教室数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function () {
        return exportClassroom(queryParams);
      }).then(response => {
        this.download(response.msg);
      })
    }
  }
};
</script>
