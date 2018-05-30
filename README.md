# BaseProject项目基础
* 是否引入ButterKnife
* ButterKnife在library和组件化的时候很不方便，这里先不适用ButterKnkife，使用findViewById,后期考虑databinding
* 插件Android Layout ID convert可以方便的生成findViewById

## 集成以下功能
* 封装MVP
* 6.0运行时权限请求的封装
* BaseRecyclerView封装
* RxJava以及RxManage对线程管理
* 异常崩溃的捕获
* log日志的本地保存
* 常用的工具类
* 多编译环境buildTypes
* 防止快速点击启动多个页面
* ToolBar封装

## ComonAdapter用法
````
public class TestBaseAdapter extends CommonBaseAdapter<String> {

    public TestBaseAdapter(List mDataList) {
        super(mDataList);
    }
    
    @Override
    public int getLayoutId() {
        return R.layout.pub_item_recyclerview;
    }

    @Override
    public void conner(CommonViewHolder holder, String entity) {
        holder.setText(R.id.content_tv, entity);
    }

}
````

## BaseListActivity用法
````
public class TestListActivity extends BaseListActivity {

    private List<String> mTitles = new ArrayList<>();
    @Override
    protected void initView() {
        super.initView();
        mBaseAdapter = new TestBaseAdapter(mTitles);
        initListView();
//        enableRefresh(false);//是否屏蔽刷新
    }
}

````

##  耗时等待转圈封装
* 网络请求等耗时操作，通过BaseActivity+RxJava完成封装，通过Loadinghelper来处理同时进行多个网络请求的进度条
````
Flowable.timer(2 * 1000, TimeUnit.MILLISECONDS)
                .compose(RxUtils.<Long>getScheduler(true, getView()))
                .subscribe(new Consumer<Long>()
````
## BasePresenter的创建使用弱引用，防止内存泄漏
````
protected WeakReference<T> mViewRef;

public void attachView(T view) {
   mViewRef = new WeakReference<>(view);
}
    
```` 
## 权限完成封装，请求权限
````
permissions("短信", new String[]{Manifest.permission.SEND_SMS}, new PermissionsResultListener() {

    @Override
    public void onPermissionGranted() {
        ToastUtils.showShort("短信权限授予");
    }

    @Override
    public void onPermissionDenied() {
        ToastUtils.showShort("短信权限拒绝");
    }
});
````

##  关于toolBar的封装 
* 在BaseActviity中重写setContetnView方法，封装ToolbarManager来管理ToolBar
````
@Override
public void setContentView(int layoutResID) {
    if (R.layout.pub_activity_base == layoutResID) {
        super.setContentView(R.layout.pub_activity_base);
        mContentView = (FrameLayout) findViewById(R.id.content_view_fl);
        mContentView.removeAllViews();
    } else if (layoutResID != R.layout.pub_activity_base) {
        View addView = LayoutInflater.from(this).inflate(layoutResID, null);
        mContentView.addView(addView);
    }
}
 
标题设置：
mToolbarManager.setToolbarTitle("MVP Demo");

````
