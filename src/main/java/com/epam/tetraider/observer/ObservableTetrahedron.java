package com.epam.tetraider.observer;

import com.epam.tetraider.model.Point;
import com.epam.tetraider.model.NumberedTetrahedron;
import com.epam.tetraider.observer.interfaces.Observable;
import com.epam.tetraider.observer.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class ObservableTetrahedron extends NumberedTetrahedron implements Observable<NumberedTetrahedron> {
    private List<Observer<NumberedTetrahedron>> observers = new ArrayList<>();

    public ObservableTetrahedron(Integer id, Point topPoint, Point baseCenterPoint, Point baseTopPoint) {
        super(id, topPoint, baseCenterPoint, baseTopPoint);
    }

    public void setTopPoint(Point topPoint) {
        super.setTopPoint(topPoint);
        notifyObservers();
    }

    public void setBaseCenterPoint(Point baseCenterPoint) {
        super.setBaseCenterPoint(baseCenterPoint);
        notifyObservers();
    }

    public void setBaseTopPoint(Point baseTopPoint) {
        super.setBaseTopPoint(baseTopPoint);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer<NumberedTetrahedron> observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }
}
