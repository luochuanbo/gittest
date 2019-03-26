package com.luochuanbo.test;

import com.luochuanbo.pojo.Product;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Date:2019/3/24
 * User: luobin
 * Desc:
 */
public class SolrTest {

    private SolrServer solrServer =
            new HttpSolrServer("http://localhost:8080/solr/collection1");

    /**
     * 向索引库增加索引
     * @throws IOException
     * @throws SolrServerException
     */
    @Test
    public void saveOrUpdate() throws IOException, SolrServerException {
        Product product = new Product();
        product.setPid("8000");
        product.setName("redmi note7 pro");
        product.setCatalogName("手机");
        product.setPrice(1688D);
        product.setDescription("极致性价比");
        product.setPicture("1.jpg");

        solrServer.addBean(product);

        solrServer.commit();
    }

    /**
     * 删除
     * @throws Exception
     */
    @Test
    public void deleteByQuery()throws Exception{
        // 删除条件: catalog_name:手机
//        solrServer.deleteByQuery("catalog_name:手机");

        //删除全部
        solrServer.deleteByQuery("*:*");

        solrServer.commit();
    }

    /**
     * 查询全部索引
     */
    @Test
    public void query() throws SolrServerException {
        //创建httpsolrserver对象,连接solr服
        // 创建查询对象solrquery,封装查询条件
        SolrQuery solrQuery = new SolrQuery("*:*");
        //设置分页开始记录数
        solrQuery.setStart(0);
        // 设置每页显示记录数/
        solrQuery.setRows(20);
        // 使用httpsolrserver对象执行搜索,返回queryresponse对象
        QueryResponse query = solrServer.query(solrQuery);
        System.out.println("搜索到的总数量"+query.getResults().getNumFound());
        // 通过queryresponse对象中获取查询的结果
        List<Product> beans = query.getBeans(Product.class);
        for (Product bean : beans) {
            System.out.println("================");
            System.out.println(bean);
        }
        System.out.println("来了");
        System.out.println("xiaozhang");

    }



}
