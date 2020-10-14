# SwipeRefreshLayout
谷歌原生的下拉刷新控件

常用方法
| 方法 | 解释 |
| :-----| ----: |
| setProgressBackgroundSchemeResource(int coloRes) | 设置下拉进度条的背景颜色,默认白色。 |
| setColorSchemeResources(int…colorReslds) | 设置下拉进度条的颜色主题，参数可变，并且是资源id，最多设置四种不同的颜色 |
| isRefreshing() | 判断当前的状态是否是刷新状态。 |
| setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener listener)	 | 	设置监听，需要重写onRefresh()方法，顶部下拉时会调用这个方法，在里面实现请求数据的逻辑，设置下拉进度条消失等等。 |
| setRefreshing(boolean refreshing) | 设置刷新状态，true表示正在刷新，false表示取消刷新。 |

__1.首先在应用或模块的 build.gradle 文件中添加所需工件的依赖项：__

`dependencies {
    implementation 'androidx.swiperefreshlayout:swiperefreshlayout:1.1.0'
    }`
 
 __2.在xml文件里面添加相关代码__
 `<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <androidx.swiperefreshlayout.widget.SwipeRefreshLayout>
        
    </androidx.swiperefreshlayout.widget.SwipeRefreshLayout>

</LinearLayout>
 `
