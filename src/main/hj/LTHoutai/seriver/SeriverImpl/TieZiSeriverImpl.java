package main.hj.LTHoutai.seriver.SeriverImpl;

import main.hj.LTHoutai.common.Gong;
import main.hj.LTHoutai.dao.daoImpl.TieziDaoImpl;
import main.hj.LTHoutai.entiy.GlTz;
import main.hj.LTHoutai.entiy.Tiezi;
import main.hj.LTHoutai.seriver.TieZiSeriver;
import main.hj.luntan.entity.Bankuai;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TieZiSeriverImpl implements TieZiSeriver {
    TieziDaoImpl tieziDao=new TieziDaoImpl();
    //查询所有板块嘚内容
    @Override
    public List<main.hj.LTHoutai.entiy.Bankuai> kan() {
        return tieziDao.cha();
    }
    //根据条件查询
    @Override
    public List<GlTz> cha(Gong gong) {
        List<Tiezi> list=tieziDao.mhcx(gong);
        List<GlTz> list1=new ArrayList<>();
        for (Iterator<Tiezi> iterator=list.iterator();iterator.hasNext();){
            Tiezi tiezi=iterator.next();
            int dianzan=tieziDao.cxdz(tiezi.getTieziid());
            int pinglun=tieziDao.cxpl(tiezi.getTieziid());
            String fatieren=tieziDao.cxyh(tiezi.getUserid());
            GlTz glTz=new GlTz();
            glTz.setId(tiezi.getTieziid());
            glTz.setBiaoti(tiezi.getBiaoti());
            glTz.setFatiezhe(fatieren);
            glTz.setShijian(tiezi.getTime());
            glTz.setDianzan(dianzan);
            glTz.setPinglun(pinglun);
            list1.add(glTz);
        }
        return list1;
    }
    //根据帖子的id删除帖子
    @Override
    public int shan(int id) {
        return tieziDao.shan(id);
    }
}
