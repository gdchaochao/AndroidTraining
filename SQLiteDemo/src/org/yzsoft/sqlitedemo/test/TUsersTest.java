package org.yzsoft.sqlitedemo.test;

import java.util.List;

import org.yzsoft.sqlitedemo.util.DBOpenHandler;
import org.yzsoft.sqlitedemo.util.SQLiteDAOImpl;
import org.yzsoft.sqlitedemo.vo.TUsers;

import android.test.AndroidTestCase;
import android.util.Log;

public class TUsersTest extends AndroidTestCase {
	private static final String TAG = "这个是测试类";// 准备好TAG标识用于LOG输出，方便我们用LogCat进行调试

	public void testCreate() {
		DBOpenHandler dbHandler = new DBOpenHandler(this.getContext(), "dbtest.db", null, 1);// 创建数据库文件
		dbHandler.getWritableDatabase();
	}

	public void testSave() throws Throwable {
		SQLiteDAOImpl p = new SQLiteDAOImpl(this.getContext());
		TUsers tuser = new TUsers();
		tuser.setUsername("用户");
		tuser.setPass("密码");
		p.save(tuser);
		Log.i(TAG, "插入成功");// 用日志记录一个我们自定义的输出。可以在LogCat窗口中查看，方便调试
	}

	public void testUpate() throws Throwable {
		SQLiteDAOImpl p = new SQLiteDAOImpl(this.getContext());
		TUsers tuser = p.find(1);
		tuser.setUsername("张三");
		p.update(tuser);
		Log.i(TAG, "修改成功");
	}

	public void testDelete() throws Throwable {
		SQLiteDAOImpl p = new SQLiteDAOImpl(this.getContext());
		p.delete(2);
		Log.i(TAG, "删除成功");
	}

	public void testFind() throws Throwable {
		SQLiteDAOImpl p = new SQLiteDAOImpl(this.getContext());
		TUsers tuser = p.find(1);
		Log.i(TAG, tuser.getUsername() + "   用户名");
	}

	public void testGetCount() throws Throwable {
		SQLiteDAOImpl p = new SQLiteDAOImpl(this.getContext());
		Log.i(TAG, p.getCount() + "   总记录数");
	}

	public void testFindAll() throws Throwable {
		SQLiteDAOImpl p = new SQLiteDAOImpl(this.getContext());
		List<TUsers> tusers = p.findAll();
		for (TUsers tuser : tusers) {
			Log.i(TAG, tuser.getUsername() + "   用户名");
		}
	}
}
