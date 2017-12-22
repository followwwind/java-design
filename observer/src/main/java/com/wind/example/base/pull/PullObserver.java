package com.wind.example.base.pull;

/**
 * 拉数据模式观察者
 * @author wind
 */
public class PullObserver implements IPullObserver{

    private IPullSubject subject;

    private String personName;

    private boolean flag;

    public PullObserver() {
    }


    public PullObserver(IPullSubject subject, String personName, boolean flag) {
        this.subject = subject;
        this.personName = personName;
        this.flag = flag;
        subject.addObserver(this);
    }


    @Override
    public void update() {
        if(subject instanceof PullSubject){
            PullSubject pullSubject = (PullSubject) subject;
            if(flag){
                System.out.println("personName=" + personName + ",goodName=" + pullSubject.getGoodName());
            }else{
                System.out.println("personName=" + personName + ",oldPrice=" + pullSubject.getOldPrice() + ",newPrice=" + pullSubject.getNewPrice());
            }
        }
    }
}
