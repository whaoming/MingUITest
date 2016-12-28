package ming.wxxiaomi.com.minguitest.ui.search.baseadapter.interfaces;


import ming.wxxiaomi.com.minguitest.ui.search.baseadapter.ViewHolder;

/**
 * Author: Othershe
 * Time: 2016/8/29 10:48
 */
public interface OnItemClickListener<T> {
    void onItemClick(ViewHolder viewHolder, T data, int position);
}
