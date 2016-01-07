import org.restlet.data.ChallengeRequest;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

/**
 * ***************************************************************************
 * Copyright (c) 2000-2016 e-Deal
 * E DEAL
 * 41 RUE PERIER
 * 92120 MONTROUGE
 * France
 * T: + 33 (0)1 73 03 29 80
 * F: + 33 (0)1 73 01 69 77
 * http://www.e-deal.com
 * La diffusion de ce code source sous quelque forme que ce soit sans
 * l'autorisation de E-DEAL est interdite.
 * Vous étes autorisés à modifier ce code source uniquement pour votre usage
 * propre et sous réserve que les mentions de copyright demeurent intactes.
 * Ce code est fourni en l'état. Aucune garantie d'aucune sorte, explicite ou
 * implicite n'est donnée. En aucun cas E-DEAL ne pourra être tenu pour
 * responsable des dommages pouvant résulter de l'utilisation de ce code
 * source.
 * ****************************************************************************
 */
public class tools {

	/**
	 * Digest resolution method
	 *
	 * @param resource current http resource
	 * @return Client resource
	 * @throws Exception
	 */
	public static ClientResource DigestResolution(ClientResource resource) throws Exception {
		String login, password;
		login = "edeal";
		password = "toto";
		try {
			resource.get();
		} catch (ResourceException re) {
			//catch 401 exception to challenge digest authentication
		}
		ChallengeRequest c1 = null;
		for (ChallengeRequest challengeRequest : resource.getChallengeRequests()) {
			if (ChallengeScheme.HTTP_DIGEST.equals(challengeRequest.getScheme())) {
				c1 = challengeRequest;
				break;
			}
		}
		ChallengeResponse challengeResponse = new ChallengeResponse(c1,
				resource.getResponse(),
				login,
				password.toCharArray());
		resource.setChallengeResponse(challengeResponse);
		return resource;
	}
}
