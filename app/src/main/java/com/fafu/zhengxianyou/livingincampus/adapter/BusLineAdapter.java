package com.fafu.zhengxianyou.livingincampus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.amap.api.services.busline.BusLineItem;
import com.fafu.zhengxianyou.livingincampus.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BusLineAdapter extends BaseAdapter {
	private List<BusLineItem> busLineItems;
	private LayoutInflater layoutInflater;

	public BusLineAdapter(Context context, List<BusLineItem> busLineItems) {

		this.busLineItems = busLineItems;
		layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return busLineItems.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.busline_item, null);
			holder = new ViewHolder();
			holder.busName = (TextView) convertView.findViewById(R.id.busname);
			holder.fl_time = (TextView) convertView.findViewById(R.id.fl_time);
			holder.busId = (TextView) convertView.findViewById(R.id.busid);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date sDate,eDate;
		String start ,end;
		sDate = busLineItems.get(position).getFirstBusTime();
		eDate = busLineItems.get(position).getLastBusTime();
		if (sDate != null&&eDate != null) {
			start = sdf.format(sDate);
			end = sdf.format(eDate);
		}else {
			start = end ="未提供";
		}
		holder.busName.setText("公 交 名  : "
				+ busLineItems.get(position).getBusLineName());
		holder.fl_time.setText("起始时间: "+start+" --> "+end);
		holder.busId.setText("公 交 ID  : "
				+ busLineItems.get(position).getBusLineId());
		return convertView;
	}

	class ViewHolder {
		public TextView busName;
		public TextView fl_time;
		public TextView busId;
	}

}
