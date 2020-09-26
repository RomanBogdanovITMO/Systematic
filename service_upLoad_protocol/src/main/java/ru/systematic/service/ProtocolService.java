package ru.systematic.service;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import ru.systematic.model.InformationForProtocol;
import ru.systematic.model.Protocol;
import ru.systematic.repo.ProtocolRepo;

import java.util.List;

@Service
public class ProtocolService {
    private final ProtocolRepo repo;

    public ProtocolService(ProtocolRepo repo) {
        this.repo = repo;
    }

    public boolean addProtocol(Protocol protocol) {
        if (protocol == null) return false;
        repo.save(protocol);
        return true;
    }

    public List<Protocol> findAll() {
        return Lists.newArrayList(repo.findAll());
    }

    public Protocol getProtocolById(int idProtocol, int idInfoFirst, int idInfoSecond) {

        if (idProtocol == 0 && idInfoFirst == 0 & idInfoSecond == 0) return null;

        Protocol protocol = repo.findById(idProtocol).get();

        protocol.getListCandidate().forEach(candidate -> {
            double value = candidate.getCount() /
                    (getCountResultInfo(protocol.getListInfoForProtocol(), idInfoFirst, idInfoSecond) * 0.01);
            double scale = Math.pow(10, 3);
            double resultValueCandidate = Math.ceil(value * scale) / scale;
            candidate.setCount(resultValueCandidate);
        });
        return protocol;
    }
    // получаем сумму из двух выбранных сведений
    private int getCountResultInfo(List<InformationForProtocol> listInfo, int idInfoFirst, int idInfoSecond) {
        int valueInfoFirst = 0;
        int valueInfoSecond = 0;

        for (InformationForProtocol information : listInfo) {
            if (information.getId() == idInfoFirst) valueInfoFirst = information.getCount();
            if (information.getId() == idInfoSecond) valueInfoSecond = information.getCount();
        }

        return  valueInfoFirst + valueInfoSecond;
    }

}
