package dbconnections;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import org.bson.Document;

public class RedisConnection {
	static final String DB_URL = "localhost";
	static final int PORT = 6666;
	
	public List<Map<String, String>> makeQueryHash(String key_pattern)  {
		JedisPool pool = new JedisPool(DB_URL, PORT);
		Jedis jedis = pool.getResource();
		Set<String> keys = jedis.keys(key_pattern);
		
		List<Map<String, String>> result = new ArrayList<>();
		for (String key : keys) {
			result.add(jedis.hgetAll(key));
		}
		
		pool.close();
		return result;
	}
	
	public Map<String, String> makeQueryString(String key_pattern)  {
		JedisPool pool = new JedisPool(DB_URL, PORT);
		Jedis jedis = pool.getResource();
		Set<String> keys = jedis.keys(key_pattern);
		
		Map<String, String> result = new HashMap<>();
		for (String key : keys) {
			result.put(key, jedis.get(key));
		}
		
		pool.close();
		return result;
	}
}
