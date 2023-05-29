<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">

      <el-form-item label="互联网/IT/电子/通信行业分析" prop="occupied">
        <el-select v-model="queryParams.occupied" placeholder="请选择分析类型" clearable size="small">
          <el-option
            v-for="dict in industryDimension"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>

<!--      <el-form-item label="区域维度" prop="occupied">-->
<!--        <el-select v-model="queryParams.occupied" placeholder="请选择区域维度" clearable size="small">-->
<!--          <el-option-->
<!--            v-for="dict in regionalDimension"-->
<!--            :key="dict.dictValue"-->
<!--            :label="dict.dictLabel"-->
<!--            :value="dict.dictValue"-->
<!--          />-->
<!--        </el-select>-->
<!--      </el-form-item>-->

<!--      <el-form-item label="年龄维度" prop="occupied">-->
<!--        <el-select v-model="queryParams.occupied" placeholder="请选择年龄维度" clearable size="small">-->
<!--          <el-option-->
<!--            v-for="dict in ageDimension"-->
<!--            :key="dict.dictValue"-->
<!--            :label="dict.dictLabel"-->
<!--            :value="dict.dictValue"-->
<!--          />-->
<!--        </el-select>-->
<!--      </el-form-item>-->


      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleChange">查询图表</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <div v-if="pieShow">
      <img src="@/assets/images/data.png">
    </div>
    <div v-if="labelShow">
      <img src="@/assets/images/img_1.png">
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
      labelShow: false,
      pieShow: false
    };
  },
  created() {
    this.getList();
    this.getDicts("industry_dimension_type").then(response => {
      this.industryDimension = response.data;
    }),
      this.getDicts("data_type").then(response => {
        this.regionalDimension = response.data;
      }),
      this.getDicts("data_type").then(response => {
        this.ageDimension = response.data;
      });
  },
  methods: {
    handleChange() {
      let imgShow = this.occupiedOptions[this.queryParams.occupied].dictLabel
      if (imgShow === '柱状图') {
        this.pieShow = false
        this.labelShow = true
      } else if (imgShow === '饼状图') {
        this.labelShow = false
        this.pieShow = true

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
