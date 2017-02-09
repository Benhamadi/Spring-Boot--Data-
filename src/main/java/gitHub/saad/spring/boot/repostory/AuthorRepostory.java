package gitHub.saad.spring.boot.repostory;

import javax.transaction.Transactional;

import gitHub.saad.spring.boot.model.User;

@Transactional
public interface AuthorRepostory extends UserRepostory<User>{
}
